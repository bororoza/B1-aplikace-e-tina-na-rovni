package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.KeyWord
import com.example.data.PreferencesManager
import com.example.data.SentencePuzzle
import com.example.data.Topic
import com.example.data.TopicsRepository
import com.example.data.db.StudentEntity
import com.example.data.db.TopicProgressEntity
import com.example.data.db.VocabularyBankEntity
import com.example.data.repository.StudentRepository
import com.example.tts.CzechTtsManager
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class CurrentScreen {
    TOPICS_LIST,
    TOPIC_DETAIL,
    VOCABULARY_BANK,
    STUDENT_PROGRESS
}

enum class TrainerTab(val title: String, val icon: String, val description: String) {
    ANALYSIS("1. Analýza", "🔍", "Text monologu, lingvistická analýza a doporučení"),
    VOCABULARY("2. Slovíčka", "🧩", "Klíčová slova B1 (CZ / EN / RU), rozdělení a kvízy"),
    VANISHING("3. Zmizík", "👁️", "Trénink paměti postupným zakrýváním slov"),
    PUZZLE("4. Puzzle", "🧩", "Syntaktický dril a skládání vět z monologu"),
    KEYWORDS("5. Osnova", "🗺️", "Asociační mapa a kognitivní záchytné body"),
    PROMPTS("6. Stimuly", "🎴", "Simulace ústní zkoušky a zkouškové kartičky")
}

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val prefsManager = PreferencesManager(application)
    private val studentRepository = StudentRepository.create(application)
    val ttsManager = CzechTtsManager(application)

    // Navigation state
    private val _currentScreen = MutableStateFlow(CurrentScreen.TOPICS_LIST)
    val currentScreen: StateFlow<CurrentScreen> = _currentScreen.asStateFlow()

    // Student profile & state
    val allStudents: StateFlow<List<StudentEntity>> = studentRepository.allStudents
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _activeStudent = MutableStateFlow<StudentEntity?>(null)
    val activeStudent: StateFlow<StudentEntity?> = _activeStudent.asStateFlow()

    // Vocabulary bank for active student
    val vocabularyBank: StateFlow<List<VocabularyBankEntity>> = _activeStudent.flatMapLatest { student: StudentEntity? ->
        if (student != null) {
            studentRepository.getBankForStudent(student.id)
        } else {
            flowOf(emptyList())
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Progress for all topics for active student
    val studentProgressMap: StateFlow<Map<String, TopicProgressEntity>> = _activeStudent.flatMapLatest { student: StudentEntity? ->
        if (student != null) {
            studentRepository.getProgressForStudent(student.id).map { list ->
                list.associateBy { it.topicId }
            }
        } else {
            flowOf(emptyMap())
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyMap())

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow("Všechna témata")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()

    private val _showFavoritesOnly = MutableStateFlow(false)
    val showFavoritesOnly: StateFlow<Boolean> = _showFavoritesOnly.asStateFlow()

    private val _favorites = MutableStateFlow(prefsManager.getFavorites())
    val favorites: StateFlow<Set<String>> = _favorites.asStateFlow()

    private val _masteredTopics = MutableStateFlow(prefsManager.getMasteredTopics())
    val masteredTopics: StateFlow<Set<String>> = _masteredTopics.asStateFlow()

    private val _masteredCards = MutableStateFlow(prefsManager.getMasteredCards())
    val masteredCards: StateFlow<Set<String>> = _masteredCards.asStateFlow()

    private val _selectedTopic = MutableStateFlow<Topic?>(null)
    val selectedTopic: StateFlow<Topic?> = _selectedTopic.asStateFlow()

    private val _activeTab = MutableStateFlow(TrainerTab.ANALYSIS)
    val activeTab: StateFlow<TrainerTab> = _activeTab.asStateFlow()

    // Vanishing Drill State
    private val _maskPercent = MutableStateFlow(0)
    val maskPercent: StateFlow<Int> = _maskPercent.asStateFlow()

    private val _isFirstLettersOnly = MutableStateFlow(false)
    val isFirstLettersOnly: StateFlow<Boolean> = _isFirstLettersOnly.asStateFlow()

    private val _revealedWordIndices = MutableStateFlow<Set<Int>>(emptySet())
    val revealedWordIndices: StateFlow<Set<Int>> = _revealedWordIndices.asStateFlow()

    // Puzzle State
    private val _puzzles = MutableStateFlow<List<SentencePuzzle>>(emptyList())
    val puzzles: StateFlow<List<SentencePuzzle>> = _puzzles.asStateFlow()

    private val _activePuzzleIndex = MutableStateFlow(0)
    val activePuzzleIndex: StateFlow<Int> = _activePuzzleIndex.asStateFlow()

    private val _selectedTokens = MutableStateFlow<List<String>>(emptyList())
    val selectedTokens: StateFlow<List<String>> = _selectedTokens.asStateFlow()

    private val _showHint = MutableStateFlow(false)
    val showHint: StateFlow<Boolean> = _showHint.asStateFlow()

    // Speech Timer State (B1 oral monologue timer: 2 to 3 minutes)
    private val _timerSeconds = MutableStateFlow(120)
    val timerSeconds: StateFlow<Int> = _timerSeconds.asStateFlow()

    private val _timerRunning = MutableStateFlow(false)
    val timerRunning: StateFlow<Boolean> = _timerRunning.asStateFlow()

    private var timerJob: Job? = null

    val filteredTopics = combine(
        _searchQuery,
        _selectedCategory,
        _showFavoritesOnly,
        _favorites
    ) { query, category, favOnly, favSet ->
        TopicsRepository.allTopics.filter { topic ->
            val matchesQuery = query.isBlank() ||
                    topic.title.contains(query, ignoreCase = true) ||
                    topic.text.any { it.contains(query, ignoreCase = true) }
            val matchesCategory = category == "Všechna témata" || topic.category == category
            val matchesFav = !favOnly || favSet.contains(topic.id)
            matchesQuery && matchesCategory && matchesFav
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, TopicsRepository.allTopics)

    init {
        viewModelScope.launch {
            val student = studentRepository.ensureActiveStudent()
            _activeStudent.value = student
        }
    }

    fun navigateTo(screen: CurrentScreen) {
        ttsManager.stop()
        _currentScreen.value = screen
    }

    // Student Management
    fun registerStudent(name: String, preferredLanguage: String, goal: String) {
        viewModelScope.launch {
            val student = studentRepository.createStudent(name, preferredLanguage, goal)
            _activeStudent.value = student
        }
    }

    fun switchStudent(studentId: String) {
        viewModelScope.launch {
            studentRepository.switchStudent(studentId)
            val student = studentRepository.ensureActiveStudent()
            _activeStudent.value = student
        }
    }

    // Vocabulary Bank Management
    fun addWordToBank(word: KeyWord, topicId: String) {
        val student = _activeStudent.value ?: return
        viewModelScope.launch {
            studentRepository.addWordToBank(student.id, word, topicId)
        }
    }

    fun markWordLearned(word: KeyWord, topicId: String) {
        val student = _activeStudent.value ?: return
        viewModelScope.launch {
            studentRepository.markWordLearned(student.id, word, topicId)
        }
    }

    fun addCustomWordToBank(czech: String, english: String, russian: String, example: String, notes: String) {
        val student = _activeStudent.value ?: return
        viewModelScope.launch {
            studentRepository.addCustomWordToBank(student.id, czech, english, russian, example, notes)
        }
    }

    fun setWordLearned(id: String, isLearned: Boolean) {
        viewModelScope.launch {
            studentRepository.setWordLearned(id, isLearned)
        }
    }

    fun deleteWordFromBank(id: String) {
        viewModelScope.launch {
            studentRepository.deleteWordFromBank(id)
        }
    }

    // Exercise Completion Tracking
    fun markAnalysisCompleted(topicId: String) {
        val student = _activeStudent.value ?: return
        viewModelScope.launch {
            studentRepository.markExerciseDone(student.id, topicId, analysis = true)
        }
    }

    fun markVocabMatchCompleted(topicId: String) {
        val student = _activeStudent.value ?: return
        viewModelScope.launch {
            studentRepository.markExerciseDone(student.id, topicId, vocabMatch = true)
        }
    }

    fun markVocabClozeCompleted(topicId: String) {
        val student = _activeStudent.value ?: return
        viewModelScope.launch {
            studentRepository.markExerciseDone(student.id, topicId, vocabCloze = true)
        }
    }

    fun markVanishingCompleted(topicId: String) {
        val student = _activeStudent.value ?: return
        viewModelScope.launch {
            studentRepository.markExerciseDone(student.id, topicId, vanishing = true)
        }
    }

    fun markPuzzleCompleted(topicId: String) {
        val student = _activeStudent.value ?: return
        viewModelScope.launch {
            studentRepository.markExerciseDone(student.id, topicId, puzzle = true)
        }
    }

    fun onSearchQueryChanged(q: String) {
        _searchQuery.value = q
    }

    fun onCategorySelected(c: String) {
        _selectedCategory.value = c
    }

    fun toggleFavoritesOnly() {
        _showFavoritesOnly.value = !_showFavoritesOnly.value
    }

    fun toggleFavorite(topicId: String) {
        prefsManager.toggleFavorite(topicId)
        _favorites.value = prefsManager.getFavorites()
        val student = _activeStudent.value ?: return
        viewModelScope.launch {
            studentRepository.toggleTopicFavorite(student.id, topicId)
        }
    }

    fun toggleMasteredTopic(topicId: String) {
        prefsManager.toggleMasteredTopic(topicId)
        _masteredTopics.value = prefsManager.getMasteredTopics()
        val student = _activeStudent.value ?: return
        viewModelScope.launch {
            studentRepository.toggleTopicMastered(student.id, topicId)
        }
    }

    fun toggleMasteredCard(topicId: String, cardIndex: Int) {
        val key = "${topicId}_$cardIndex"
        prefsManager.toggleMasteredCard(key)
        _masteredCards.value = prefsManager.getMasteredCards()

        val student = _activeStudent.value ?: return
        viewModelScope.launch {
            studentRepository.toggleCardMastered(student.id, topicId, cardIndex)
        }
    }

    fun selectTopic(topic: Topic?) {
        ttsManager.stop()
        stopTimer()
        _selectedTopic.value = topic
        _activeTab.value = TrainerTab.ANALYSIS
        if (topic != null) {
            resetVanishingState()
            loadPuzzlesForTopic(topic)
            markAnalysisCompleted(topic.id)
            _currentScreen.value = CurrentScreen.TOPIC_DETAIL
        } else {
            _currentScreen.value = CurrentScreen.TOPICS_LIST
        }
    }

    fun selectTab(tab: TrainerTab) {
        ttsManager.stop()
        _activeTab.value = tab
    }

    // Vanishing controls
    fun setMaskPercent(percent: Int) {
        _isFirstLettersOnly.value = false
        _maskPercent.value = percent
        _revealedWordIndices.value = emptySet()
        if (percent >= 50) {
            _selectedTopic.value?.let { markVanishingCompleted(it.id) }
        }
    }

    fun setFirstLettersOnly() {
        _isFirstLettersOnly.value = true
        _maskPercent.value = 0
        _revealedWordIndices.value = emptySet()
        _selectedTopic.value?.let { markVanishingCompleted(it.id) }
    }

    fun revealWord(index: Int) {
        _revealedWordIndices.value = _revealedWordIndices.value + index
    }

    fun revealAllWords() {
        _revealedWordIndices.value = (0..2000).toSet()
    }

    fun resetVanishingState() {
        _maskPercent.value = 0
        _isFirstLettersOnly.value = false
        _revealedWordIndices.value = emptySet()
    }

    // Puzzle controls
    private fun loadPuzzlesForTopic(topic: Topic) {
        val generated = TopicsRepository.generatePuzzlesForTopic(topic)
        _puzzles.value = generated
        _activePuzzleIndex.value = 0
        _selectedTokens.value = emptyList()
        _showHint.value = false
    }

    fun selectPuzzleIndex(index: Int) {
        val list = _puzzles.value
        if (index in list.indices) {
            _activePuzzleIndex.value = index
            _selectedTokens.value = emptyList()
            _showHint.value = false
        }
    }

    fun addPuzzleToken(token: String) {
        _selectedTokens.value = _selectedTokens.value + token
        val curIndex = _activePuzzleIndex.value
        val curPuzzle = _puzzles.value.getOrNull(curIndex)
        if (curPuzzle != null && _selectedTokens.value == curPuzzle.tokens) {
            _selectedTopic.value?.let { markPuzzleCompleted(it.id) }
        }
    }

    fun removePuzzleTokenAt(index: Int) {
        val current = _selectedTokens.value.toMutableList()
        if (index in current.indices) {
            current.removeAt(index)
            _selectedTokens.value = current
        }
    }

    fun resetCurrentPuzzle() {
        _selectedTokens.value = emptyList()
        _showHint.value = false
    }

    fun toggleHint() {
        _showHint.value = !_showHint.value
    }

    // Timer controls
    fun toggleTimer() {
        if (_timerRunning.value) {
            stopTimer()
        } else {
            startTimer()
        }
    }

    fun startTimer() {
        timerJob?.cancel()
        _timerRunning.value = true
        timerJob = viewModelScope.launch {
            while (_timerSeconds.value > 0 && _timerRunning.value) {
                delay(1000)
                if (_timerRunning.value) {
                    _timerSeconds.value = _timerSeconds.value - 1
                }
            }
            _timerRunning.value = false
        }
    }

    fun stopTimer() {
        _timerRunning.value = false
        timerJob?.cancel()
    }

    fun resetTimer(seconds: Int = 120) {
        stopTimer()
        _timerSeconds.value = seconds
    }

    override fun onCleared() {
        super.onCleared()
        ttsManager.shutdown()
        stopTimer()
    }
}
