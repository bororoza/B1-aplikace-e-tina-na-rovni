package com.example.data.repository

import android.content.Context
import com.example.data.KeyWord
import com.example.data.PreferencesManager
import com.example.data.db.AppDao
import com.example.data.db.AppDatabase
import com.example.data.db.StudentEntity
import com.example.data.db.TopicProgressEntity
import com.example.data.db.VocabularyBankEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.util.UUID

class StudentRepository(
    private val appDao: AppDao,
    private val prefsManager: PreferencesManager
) {
    val allStudents: Flow<List<StudentEntity>> = appDao.getAllStudents()

    fun getProgressForStudent(studentId: String): Flow<List<TopicProgressEntity>> {
        return appDao.getProgressForStudent(studentId)
    }

    fun getBankForStudent(studentId: String): Flow<List<VocabularyBankEntity>> {
        return appDao.getBankForStudent(studentId)
    }

    suspend fun ensureActiveStudent(): StudentEntity = withContext(Dispatchers.IO) {
        val savedId = prefsManager.getActiveStudentId()
        if (savedId != null) {
            val existing = appDao.getStudentById(savedId)
            if (existing != null) return@withContext existing
        }
        val defaultStudent = StudentEntity(
            id = UUID.randomUUID().toString(),
            name = "Student 1",
            preferredLanguage = "EN",
            goal = "Ústní zkouška B1"
        )
        appDao.insertStudent(defaultStudent)
        prefsManager.setActiveStudentId(defaultStudent.id)
        defaultStudent
    }

    suspend fun createStudent(name: String, preferredLanguage: String, goal: String): StudentEntity = withContext(Dispatchers.IO) {
        val student = StudentEntity(
            id = UUID.randomUUID().toString(),
            name = name.ifBlank { "Student" },
            preferredLanguage = preferredLanguage,
            goal = goal.ifBlank { "Ústní zkouška B1" }
        )
        appDao.insertStudent(student)
        prefsManager.setActiveStudentId(student.id)
        student
    }

    suspend fun switchStudent(studentId: String) = withContext(Dispatchers.IO) {
        prefsManager.setActiveStudentId(studentId)
    }

    suspend fun updateStudent(student: StudentEntity) = withContext(Dispatchers.IO) {
        appDao.insertStudent(student)
    }

    suspend fun deleteStudent(studentId: String) = withContext(Dispatchers.IO) {
        appDao.deleteStudent(studentId)
    }

    suspend fun getOrCreateProgress(studentId: String, topicId: String): TopicProgressEntity = withContext(Dispatchers.IO) {
        appDao.getProgressForTopic(studentId, topicId) ?: TopicProgressEntity(
            studentId = studentId,
            topicId = topicId
        )
    }

    suspend fun markExerciseDone(
        studentId: String,
        topicId: String,
        analysis: Boolean? = null,
        vocabMatch: Boolean? = null,
        vocabCloze: Boolean? = null,
        vanishing: Boolean? = null,
        puzzle: Boolean? = null,
        outline: Boolean? = null
    ) = withContext(Dispatchers.IO) {
        val current = getOrCreateProgress(studentId, topicId)
        val updated = current.copy(
            analysisDone = analysis ?: current.analysisDone,
            vocabMatchDone = vocabMatch ?: current.vocabMatchDone,
            vocabClozeDone = vocabCloze ?: current.vocabClozeDone,
            vanishingDone = vanishing ?: current.vanishingDone,
            puzzleDone = puzzle ?: current.puzzleDone,
            outlineDone = outline ?: current.outlineDone,
            lastUpdated = System.currentTimeMillis()
        )
        appDao.insertOrUpdateProgress(updated)
    }

    suspend fun toggleTopicMastered(studentId: String, topicId: String): Boolean = withContext(Dispatchers.IO) {
        val current = getOrCreateProgress(studentId, topicId)
        val newStatus = !current.isMastered
        appDao.insertOrUpdateProgress(
            current.copy(
                isMastered = newStatus,
                lastUpdated = System.currentTimeMillis()
            )
        )
        newStatus
    }

    suspend fun toggleTopicFavorite(studentId: String, topicId: String): Boolean = withContext(Dispatchers.IO) {
        val current = getOrCreateProgress(studentId, topicId)
        val newStatus = !current.isFavorite
        appDao.insertOrUpdateProgress(
            current.copy(
                isFavorite = newStatus,
                lastUpdated = System.currentTimeMillis()
            )
        )
        newStatus
    }

    suspend fun toggleCardMastered(studentId: String, topicId: String, cardIndex: Int) = withContext(Dispatchers.IO) {
        val current = getOrCreateProgress(studentId, topicId)
        val set = current.masteredCards.split(",")
            .filter { it.isNotBlank() }
            .mapNotNull { it.toIntOrNull() }
            .toMutableSet()
        if (set.contains(cardIndex)) {
            set.remove(cardIndex)
        } else {
            set.add(cardIndex)
        }
        val serialized = set.joinToString(",")
        appDao.insertOrUpdateProgress(
            current.copy(
                masteredCards = serialized,
                lastUpdated = System.currentTimeMillis()
            )
        )
    }

    suspend fun addWordToBank(studentId: String, word: KeyWord, topicId: String) = withContext(Dispatchers.IO) {
        val item = VocabularyBankEntity(
            id = "${studentId}_${word.id}",
            studentId = studentId,
            topicId = topicId,
            czech = word.czech,
            english = word.english,
            russian = word.russian,
            example = word.example,
            exampleEn = word.exampleEn,
            exampleRu = word.exampleRu,
            isLearned = false
        )
        appDao.insertVocabularyItem(item)
    }

    suspend fun markWordLearned(studentId: String, word: KeyWord, topicId: String) = withContext(Dispatchers.IO) {
        val item = VocabularyBankEntity(
            id = "${studentId}_${word.id}",
            studentId = studentId,
            topicId = topicId,
            czech = word.czech,
            english = word.english,
            russian = word.russian,
            example = word.example,
            exampleEn = word.exampleEn,
            exampleRu = word.exampleRu,
            isLearned = true
        )
        appDao.insertVocabularyItem(item)
    }

    suspend fun addCustomWordToBank(
        studentId: String,
        czech: String,
        english: String,
        russian: String,
        example: String,
        notes: String
    ) = withContext(Dispatchers.IO) {
        val item = VocabularyBankEntity(
            id = UUID.randomUUID().toString(),
            studentId = studentId,
            topicId = "custom",
            czech = czech.trim(),
            english = english.trim(),
            russian = russian.trim(),
            example = example.trim(),
            exampleEn = "",
            exampleRu = "",
            isLearned = false,
            notes = notes.trim()
        )
        appDao.insertVocabularyItem(item)
    }

    suspend fun setWordLearned(id: String, isLearned: Boolean) = withContext(Dispatchers.IO) {
        appDao.updateVocabularyLearnedStatus(id, isLearned)
    }

    suspend fun deleteWordFromBank(id: String) = withContext(Dispatchers.IO) {
        appDao.deleteVocabularyItem(id)
    }

    companion object {
        fun create(context: Context): StudentRepository {
            val db = AppDatabase.getInstance(context)
            val prefs = PreferencesManager(context)
            return StudentRepository(db.appDao(), prefs)
        }
    }
}
