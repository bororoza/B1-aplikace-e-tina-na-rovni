package com.example.ui.screens.tabs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.KeyWord
import com.example.data.Topic
import com.example.ui.MainViewModel
import com.example.ui.theme.AccentAmber
import com.example.ui.theme.AccentAmberLight
import com.example.ui.theme.CzechBlueDark
import com.example.ui.theme.DoodleBlack
import com.example.ui.theme.LogoPink
import com.example.ui.theme.LogoPinkDark
import com.example.ui.theme.PrimaryAccent
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.theme.PrimaryLight
import com.example.ui.theme.Rose100
import com.example.ui.theme.Rose600
import com.example.ui.theme.SecondaryEmerald
import com.example.ui.theme.SecondaryEmeraldAccent
import com.example.ui.theme.SecondaryEmeraldLight
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate500
import com.example.ui.theme.Slate600
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate800

enum class VocabSubMode(val title: String, val icon: String) {
    CARDS("Slovníček", "📖"),
    MATCHING("Spojování", "🔗"),
    CLOZE("Doplňování", "✍️")
}

@Composable
fun VocabularyTab(
    topic: Topic,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val keyWords = topic.keyWords
    val vocabularyBank by viewModel.vocabularyBank.collectAsState()
    val bankWordIds = remember(vocabularyBank) {
        vocabularyBank.map { it.id }.toSet()
    }
    val learnedWordIds = remember(vocabularyBank) {
        vocabularyBank.filter { it.isLearned }.map { it.id }.toSet()
    }
    val activeStudent by viewModel.activeStudent.collectAsState()
    val studentLang = activeStudent?.preferredLanguage ?: "EN"

    var subMode by remember { mutableStateOf(VocabSubMode.CARDS) }
    var displayLang by remember { mutableStateOf(if (studentLang == "RU") "RU" else "EN") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Sub-mode tabs & language toggle
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 2.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Klíčová slova B1 (${keyWords.size})",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Slate800
                    )

                    // Language toggles: EN / RU / BOTH
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Překlad:", style = MaterialTheme.typography.labelSmall, color = Slate600)
                        FilterChip(
                            selected = displayLang == "EN",
                            onClick = { displayLang = "EN" },
                            label = { Text("🇬🇧 EN") },
                            modifier = Modifier.height(30.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = PrimaryIndigo,
                                selectedLabelColor = Color.White
                            )
                        )
                        FilterChip(
                            selected = displayLang == "RU",
                            onClick = { displayLang = "RU" },
                            label = { Text("🇷🇺 RU") },
                            modifier = Modifier.height(30.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = PrimaryIndigo,
                                selectedLabelColor = Color.White
                            )
                        )
                        FilterChip(
                            selected = displayLang == "BOTH",
                            onClick = { displayLang = "BOTH" },
                            label = { Text("🇨🇿 Obě") },
                            modifier = Modifier.height(30.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = PrimaryIndigo,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }

                TabRow(
                    selectedTabIndex = subMode.ordinal,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    VocabSubMode.entries.forEach { mode ->
                        Tab(
                            selected = subMode == mode,
                            onClick = { subMode = mode },
                            text = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(mode.icon, fontSize = 14.sp)
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(mode.title, fontWeight = if (subMode == mode) FontWeight.Bold else FontWeight.Normal)
                                }
                            }
                        )
                    }
                }
            }
        }

        when (subMode) {
            VocabSubMode.CARDS -> {
                VocabCardsSubTab(
                    topic = topic,
                    keyWords = keyWords,
                    displayLang = displayLang,
                    viewModel = viewModel,
                    bankWordIds = bankWordIds,
                    learnedWordIds = learnedWordIds
                )
            }
            VocabSubMode.MATCHING -> {
                VocabMatchingSubTab(
                    topic = topic,
                    keyWords = keyWords,
                    displayLang = displayLang,
                    viewModel = viewModel
                )
            }
            VocabSubMode.CLOZE -> {
                VocabClozeSubTab(
                    topic = topic,
                    keyWords = keyWords,
                    displayLang = displayLang,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
private fun VocabCardsSubTab(
    topic: Topic,
    keyWords: List<KeyWord>,
    displayLang: String,
    viewModel: MainViewModel,
    bankWordIds: Set<String>,
    learnedWordIds: Set<String>
) {
    var filterMode by remember { mutableStateOf("ALL") } // ALL, NEED_TO_LEARN, MASTERED
    val activeStudent by viewModel.activeStudent.collectAsState()
    val studentId = activeStudent?.id ?: ""

    val filteredWords = remember(keyWords, filterMode, bankWordIds, learnedWordIds, studentId) {
        when (filterMode) {
            "NEED_TO_LEARN" -> keyWords.filter {
                val fullId = "${studentId}_${it.id}"
                bankWordIds.contains(fullId) && !learnedWordIds.contains(fullId)
            }
            "MASTERED" -> keyWords.filter {
                val fullId = "${studentId}_${it.id}"
                learnedWordIds.contains(fullId)
            }
            else -> keyWords
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("vocab_cards_list"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            // Filter Pills
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FilterChip(
                    selected = filterMode == "ALL",
                    onClick = { filterMode = "ALL" },
                    label = { Text("Všechna (${keyWords.size})") }
                )
                FilterChip(
                    selected = filterMode == "NEED_TO_LEARN",
                    onClick = { filterMode = "NEED_TO_LEARN" },
                    label = { Text("K naučení") },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = AccentAmberLight,
                        selectedLabelColor = AccentAmber
                    )
                )
                FilterChip(
                    selected = filterMode == "MASTERED",
                    onClick = { filterMode = "MASTERED" },
                    label = { Text("Už umím") },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = SecondaryEmeraldLight,
                        selectedLabelColor = SecondaryEmerald
                    )
                )
            }
        }

        if (filteredWords.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("✨", fontSize = 36.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = if (filterMode == "NEED_TO_LEARN") "Žádná slova v bance k naučení." else "Žádná slova v této kategorii.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Slate600
                        )
                    }
                }
            }
        }

        items(filteredWords, key = { it.id }) { word ->
            val fullWordId = "${studentId}_${word.id}"
            val isInBank = bankWordIds.contains(fullWordId)
            val isLearned = learnedWordIds.contains(fullWordId)

            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isLearned) SecondaryEmeraldLight.copy(alpha = 0.5f)
                    else MaterialTheme.colorScheme.surface
                ),
                border = BorderStroke(
                    1.dp,
                    if (isLearned) SecondaryEmeraldAccent.copy(alpha = 0.6f)
                    else if (isInBank) AccentAmber.copy(alpha = 0.6f)
                    else Slate200
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    // Top row: Czech word + Audio button + Status badge
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = word.czech,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            IconButton(
                                onClick = { viewModel.ttsManager.speak(word.czech) },
                                modifier = Modifier.size(36.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.VolumeUp,
                                    contentDescription = "Přehrát výslovnost",
                                    tint = PrimaryIndigo,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }

                        if (isLearned) {
                            Surface(
                                color = SecondaryEmerald,
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = "✓ Umím",
                                    color = Color.White,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        } else if (isInBank) {
                            Surface(
                                color = AccentAmber,
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = "V bance",
                                    color = Color.White,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Translations
                    if (displayLang == "EN" || displayLang == "BOTH") {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🇬🇧 ", fontSize = 14.sp)
                            Text(
                                text = word.english,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Slate700,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                    if (displayLang == "RU" || displayLang == "BOTH") {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🇷🇺 ", fontSize = 14.sp)
                            Text(
                                text = word.russian,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Slate700,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Example context
                    Surface(
                        color = Color(0xFFFFF7ED),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, Color(0xFFFED7AA)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "💬 Příklad ve větě:",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Black,
                                    color = Color(0xFFC2410C)
                                )
                                IconButton(
                                    onClick = { viewModel.ttsManager.speak(word.example) },
                                    modifier = Modifier.size(28.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.VolumeUp,
                                        contentDescription = "Přehrát příklad",
                                        tint = LogoPink,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            // Český ekvivalent v příkladu - vysoký kontrast a perfektní čitelnost
                            Text(
                                text = "„${word.example}“",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = DoodleBlack,
                                lineHeight = 22.sp
                            )
                            if (displayLang == "EN" || displayLang == "BOTH") {
                                Text(
                                    text = "🇬🇧 ${word.exampleEn}",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Medium,
                                    color = CzechBlueDark,
                                    modifier = Modifier.padding(top = 5.dp)
                                )
                            }
                            if (displayLang == "RU" || displayLang == "BOTH") {
                                Text(
                                    text = "🇷🇺 ${word.exampleRu}",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFF991B1B),
                                    modifier = Modifier.padding(top = 3.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Action buttons: "Už umím" vs "Potřebuji se naučit"
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                viewModel.addWordToBank(word, topic.id)
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = if (isInBank && !isLearned) AccentAmber else Slate700
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.BookmarkAdd,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isInBank && !isLearned) "V bance" else "Naučit se",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }

                        Button(
                            onClick = {
                                viewModel.markWordLearned(word, topic.id)
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isLearned) SecondaryEmerald else PrimaryIndigo
                            )
                        ) {
                            Icon(
                                imageVector = if (isLearned) Icons.Default.Check else Icons.Outlined.CheckCircleOutline,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isLearned) "Zvládnuto" else "Umím",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun VocabMatchingSubTab(
    topic: Topic,
    keyWords: List<KeyWord>,
    displayLang: String,
    viewModel: MainViewModel
) {
    if (keyWords.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Pro toto téma nejsou k dispozici slova k párování.")
        }
        return
    }

    // Matching game state
    var selectedLeftId by remember { mutableStateOf<String?>(null) }
    var selectedRightId by remember { mutableStateOf<String?>(null) }
    val matchedIds = remember { mutableStateListOf<String>() }
    var mismatchPair by remember { mutableStateOf<Pair<String, String>?>(null) }

    val shuffledWords = remember(keyWords) { keyWords.shuffled() }
    val shuffledTranslations = remember(keyWords) { keyWords.shuffled() }

    val isAllMatched = matchedIds.size >= keyWords.size

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("vocab_matching_game"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // Header card with instructions and score
            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = PrimaryLight),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "🔗 Spojovačka: Význam & Příklady",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryIndigo
                        )
                        Surface(
                            color = PrimaryIndigo,
                            shape = CircleShape
                        ) {
                            Text(
                                text = "${matchedIds.size} / ${keyWords.size}",
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                    }
                    Text(
                        text = "Klepněte nejprve na české slovo vlevo a poté na jeho správný překlad vpravo.",
                        style = MaterialTheme.typography.bodySmall,
                        color = Slate700,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = { (matchedIds.size.toFloat() / keyWords.size).coerceIn(0f, 1f) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                            .clip(RoundedCornerShape(3.dp)),
                        color = SecondaryEmerald,
                        trackColor = Color.White
                    )
                }
            }
        }

        if (isAllMatched) {
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = SecondaryEmeraldLight),
                    border = BorderStroke(2.dp, SecondaryEmerald),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("🎉", fontSize = 40.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Výborně! Všechna slovíčka spojena!",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = SecondaryEmerald
                        )
                        Text(
                            text = "Cvičení bylo zapsáno do vašeho profilu studenta.",
                            style = MaterialTheme.typography.bodySmall,
                            color = Slate700,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        Spacer(modifier = Modifier.height(14.dp))
                        Button(
                            onClick = {
                                matchedIds.clear()
                                selectedLeftId = null
                                selectedRightId = null
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = SecondaryEmerald)
                        ) {
                            Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Hrát znovu")
                        }
                    }
                }
            }
        }

        // Two-column layout
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Left Column: Czech words
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "České slovo",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = Slate600
                    )
                    shuffledWords.forEach { word ->
                        val isMatched = matchedIds.contains(word.id)
                        val isSelected = selectedLeftId == word.id
                        val isError = mismatchPair?.first == word.id

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = when {
                                isMatched -> SecondaryEmeraldLight
                                isError -> Rose100
                                isSelected -> PrimaryLight
                                else -> MaterialTheme.colorScheme.surface
                            },
                            border = BorderStroke(
                                1.5.dp,
                                when {
                                    isMatched -> SecondaryEmerald
                                    isError -> Rose600
                                    isSelected -> PrimaryIndigo
                                    else -> Slate200
                                }
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(enabled = !isMatched) {
                                    mismatchPair = null
                                    selectedLeftId = word.id
                                    // Check match if right was already selected
                                    if (selectedRightId != null) {
                                        if (word.id == selectedRightId) {
                                            matchedIds.add(word.id)
                                            viewModel.ttsManager.speak(word.czech)
                                            selectedLeftId = null
                                            selectedRightId = null
                                            if (matchedIds.size >= keyWords.size) {
                                                viewModel.markVocabMatchCompleted(topic.id)
                                            }
                                        } else {
                                            mismatchPair = Pair(word.id, selectedRightId!!)
                                            selectedLeftId = null
                                            selectedRightId = null
                                        }
                                    }
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = word.czech,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = if (isSelected || isMatched) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isMatched) SecondaryEmerald else MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )
                                if (isMatched) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = null,
                                        tint = SecondaryEmerald,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        }
                    }
                }

                // Right Column: Translations / Definitions
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Překlad / Význam",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = Slate600
                    )
                    shuffledTranslations.forEach { word ->
                        val isMatched = matchedIds.contains(word.id)
                        val isSelected = selectedRightId == word.id
                        val isError = mismatchPair?.second == word.id

                        val translationText = when (displayLang) {
                            "RU" -> word.russian
                            "EN" -> word.english
                            else -> "${word.english}\n${word.russian}"
                        }

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = when {
                                isMatched -> SecondaryEmeraldLight
                                isError -> Rose100
                                isSelected -> PrimaryLight
                                else -> MaterialTheme.colorScheme.surface
                            },
                            border = BorderStroke(
                                1.5.dp,
                                when {
                                    isMatched -> SecondaryEmerald
                                    isError -> Rose600
                                    isSelected -> PrimaryIndigo
                                    else -> Slate200
                                }
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(enabled = !isMatched) {
                                    mismatchPair = null
                                    selectedRightId = word.id
                                    // Check match if left was already selected
                                    if (selectedLeftId != null) {
                                        if (selectedLeftId == word.id) {
                                            matchedIds.add(word.id)
                                            viewModel.ttsManager.speak(word.czech)
                                            selectedLeftId = null
                                            selectedRightId = null
                                            if (matchedIds.size >= keyWords.size) {
                                                viewModel.markVocabMatchCompleted(topic.id)
                                            }
                                        } else {
                                            mismatchPair = Pair(selectedLeftId!!, word.id)
                                            selectedLeftId = null
                                            selectedRightId = null
                                        }
                                    }
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = translationText,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = if (isSelected || isMatched) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isMatched) SecondaryEmerald else MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )
                                if (isMatched) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = null,
                                        tint = SecondaryEmerald,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun VocabClozeSubTab(
    topic: Topic,
    keyWords: List<KeyWord>,
    displayLang: String,
    viewModel: MainViewModel
) {
    val clozeWords = remember(keyWords) {
        keyWords.filter { it.clozeSentence.isNotBlank() && it.clozeOptions.isNotEmpty() }
    }

    if (clozeWords.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Pro toto téma nejsou připravena doplňovací cvičení.")
        }
        return
    }

    var currentIndex by remember { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var isAnswerCorrect by remember { mutableStateOf<Boolean?>(null) }
    val solvedIndices = remember { mutableStateListOf<Int>() }

    val currentWord = clozeWords[currentIndex.coerceIn(clozeWords.indices)]

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("vocab_cloze_drill"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // Header with question index
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "✍️ Doplňování do kontextu",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryIndigo
                )
                Text(
                    text = "Věta ${currentIndex + 1} z ${clozeWords.size}",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = Slate600
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            LinearProgressIndicator(
                progress = { ((currentIndex + 1).toFloat() / clozeWords.size).coerceIn(0f, 1f) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = PrimaryIndigo,
                trackColor = Slate200
            )
        }

        // Sentence Card
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.5.dp, PrimaryLight),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Doplňte chybějící slovo:",
                        style = MaterialTheme.typography.labelSmall,
                        color = Slate500,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = currentWord.clozeSentence,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 26.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Bilingual context hint
                    Surface(
                        color = PrimaryLight,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)) {
                            Text(
                                text = "Nápověda významu:",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryIndigo
                            )
                            if (displayLang == "EN" || displayLang == "BOTH") {
                                Text(
                                    text = "🇬🇧 ${currentWord.english}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Slate700
                                )
                            }
                            if (displayLang == "RU" || displayLang == "BOTH") {
                                Text(
                                    text = "🇷🇺 ${currentWord.russian}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Slate700
                                )
                            }
                        }
                    }
                }
            }
        }

        // 4 Options Grid
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                currentWord.clozeOptions.forEach { option ->
                    val isSelected = selectedAnswer == option
                    val isCorrectOption = option.equals(currentWord.clozeOptions.firstOrNull(), ignoreCase = true) ||
                            currentWord.clozeSentence.contains(option) // match check
                    val isOptionVerified = isAnswerCorrect != null

                    val backgroundColor = when {
                        isOptionVerified && isSelected && isAnswerCorrect == true -> SecondaryEmeraldLight
                        isOptionVerified && isSelected && isAnswerCorrect == false -> Rose100
                        else -> MaterialTheme.colorScheme.surface
                    }

                    val borderColor = when {
                        isOptionVerified && isSelected && isAnswerCorrect == true -> SecondaryEmerald
                        isOptionVerified && isSelected && isAnswerCorrect == false -> Rose600
                        isSelected -> PrimaryIndigo
                        else -> Slate200
                    }

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = backgroundColor,
                        border = BorderStroke(1.5.dp, borderColor),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(enabled = isAnswerCorrect == null) {
                                selectedAnswer = option
                                // First option or matching correct option
                                val correct = option == currentWord.clozeOptions[0]
                                isAnswerCorrect = correct
                                if (correct) {
                                    viewModel.ttsManager.speak(option)
                                    if (!solvedIndices.contains(currentIndex)) {
                                        solvedIndices.add(currentIndex)
                                    }
                                    if (solvedIndices.size >= clozeWords.size) {
                                        viewModel.markVocabClozeCompleted(topic.id)
                                    }
                                }
                            }
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = option,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            if (isOptionVerified && isSelected) {
                                if (isAnswerCorrect == true) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Správně",
                                        tint = SecondaryEmerald
                                    )
                                } else {
                                    Text(
                                        text = "✕ Zkuste znovu",
                                        color = Rose600,
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Feedback & Next Button
        item {
            AnimatedVisibility(visible = isAnswerCorrect != null) {
                Column {
                    if (isAnswerCorrect == true) {
                        Surface(
                            color = SecondaryEmeraldLight,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("✅", fontSize = 20.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "Správně!",
                                        fontWeight = FontWeight.Bold,
                                        color = SecondaryEmerald,
                                        style = MaterialTheme.typography.titleSmall
                                    )
                                    Text(
                                        text = "„${currentWord.example}“",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = Slate700
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        if (isAnswerCorrect == false) {
                            OutlinedButton(
                                onClick = {
                                    selectedAnswer = null
                                    isAnswerCorrect = null
                                }
                            ) {
                                Text("Zkusit znovu")
                            }
                        }

                        if (currentIndex < clozeWords.size - 1) {
                            Button(
                                onClick = {
                                    currentIndex++
                                    selectedAnswer = null
                                    isAnswerCorrect = null
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Další věta →")
                            }
                        } else if (isAnswerCorrect == true) {
                            Button(
                                onClick = {
                                    currentIndex = 0
                                    selectedAnswer = null
                                    isAnswerCorrect = null
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = SecondaryEmerald),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Dokončeno! Začít znovu ↺")
                            }
                        }
                    }
                }
            }
        }
    }
}
