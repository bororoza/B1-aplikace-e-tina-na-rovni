package com.example.ui.screens

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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.db.VocabularyBankEntity
import com.example.ui.MainViewModel
import com.example.ui.theme.AccentAmber
import com.example.ui.theme.AccentAmberLight
import com.example.ui.theme.DoodleBlack
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.theme.PrimaryLight
import com.example.ui.theme.Rose600
import com.example.ui.theme.SecondaryEmerald
import com.example.ui.theme.SecondaryEmeraldAccent
import com.example.ui.theme.SecondaryEmeraldLight
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate400
import com.example.ui.theme.Slate600
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate800

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VocabularyBankScreen(
    viewModel: MainViewModel,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val vocabularyBank by viewModel.vocabularyBank.collectAsState()
    val activeStudent by viewModel.activeStudent.collectAsState()
    val studentLang = activeStudent?.preferredLanguage ?: "EN"

    var searchQuery by remember { mutableStateOf("") }
    var filterTab by remember { mutableStateOf("TO_LEARN") } // TO_LEARN, MASTERED, ALL
    var showAddDialog by remember { mutableStateOf(false) }
    var isFlashcardMode by remember { mutableStateOf(false) }

    val toLearnCount = vocabularyBank.count { !it.isLearned }
    val masteredCount = vocabularyBank.count { it.isLearned }

    val filteredList = remember(vocabularyBank, searchQuery, filterTab) {
        vocabularyBank.filter { item ->
            val matchesFilter = when (filterTab) {
                "TO_LEARN" -> !item.isLearned
                "MASTERED" -> item.isLearned
                else -> true
            }
            val matchesSearch = searchQuery.isBlank() ||
                    item.czech.contains(searchQuery, ignoreCase = true) ||
                    item.english.contains(searchQuery, ignoreCase = true) ||
                    item.russian.contains(searchQuery, ignoreCase = true)
            matchesFilter && matchesSearch
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Banka slovíček",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${activeStudent?.name ?: "Student"} • $toLearnCount k naučení",
                            style = MaterialTheme.typography.labelSmall,
                            color = Slate600
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Zpět"
                        )
                    }
                },
                actions = {
                    if (toLearnCount > 0) {
                        IconButton(onClick = { isFlashcardMode = !isFlashcardMode }) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Trénink kartiček",
                                tint = PrimaryIndigo
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        },
        floatingActionButton = {
            Button(
                onClick = { showAddDialog = true },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                modifier = Modifier.testTag("add_custom_word_fab")
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
                Spacer(modifier = Modifier.width(6.dp))
                Text("Přidat slovíčko")
            }
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Flashcard review mode banner if active
            AnimatedVisibility(visible = isFlashcardMode && toLearnCount > 0) {
                BankFlashcardPractice(
                    items = vocabularyBank.filter { !it.isLearned },
                    studentLang = studentLang,
                    onSpeak = { viewModel.ttsManager.speak(it) },
                    onMarkLearned = { id -> viewModel.setWordLearned(id, true) },
                    onClose = { isFlashcardMode = false }
                )
            }

            // Stats and Filter Tabs
            Surface(
                color = MaterialTheme.colorScheme.surface,
                shadowElevation = 1.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                    // Search bar
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("bank_search_input"),
                        placeholder = { Text("Hledat v bance (česky, anglicky, rusky)...") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        },
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(onClick = { searchQuery = "" }) {
                                    Icon(imageVector = Icons.Default.Clear, contentDescription = "Vymazat")
                                }
                            }
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FilterChip(
                            selected = filterTab == "TO_LEARN",
                            onClick = { filterTab = "TO_LEARN" },
                            label = { Text("K naučení ($toLearnCount)") },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = AccentAmberLight,
                                selectedLabelColor = AccentAmber
                            )
                        )
                        FilterChip(
                            selected = filterTab == "MASTERED",
                            onClick = { filterTab = "MASTERED" },
                            label = { Text("Zvládnuto ($masteredCount)") },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = SecondaryEmeraldLight,
                                selectedLabelColor = SecondaryEmerald
                            )
                        )
                        FilterChip(
                            selected = filterTab == "ALL",
                            onClick = { filterTab = "ALL" },
                            label = { Text("Vše (${vocabularyBank.size})") }
                        )
                    }
                }
            }

            // List of words
            if (filteredList.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("🎒", fontSize = 44.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = if (vocabularyBank.isEmpty()) "Banka slovíček je zatím prázdná" else "Nenalezena žádná slova",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Slate800
                        )
                        Text(
                            text = "Klepněte na „Potřebuji se naučit“ v jakémkoliv tématu nebo přidejte vlastní slovo tlačítkem níže.",
                            style = MaterialTheme.typography.bodySmall,
                            color = Slate600,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .testTag("vocabulary_bank_list"),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(filteredList, key = { it.id }) { item ->
                        BankWordCard(
                            item = item,
                            studentLang = studentLang,
                            onSpeak = { viewModel.ttsManager.speak(item.czech) },
                            onToggleLearned = {
                                viewModel.setWordLearned(item.id, !item.isLearned)
                            },
                            onDelete = {
                                viewModel.deleteWordFromBank(item.id)
                            }
                        )
                    }
                }
            }
        }
    }

    // Add Custom Word Dialog
    if (showAddDialog) {
        AddCustomWordDialog(
            onDismiss = { showAddDialog = false },
            onAddWord = { czech, english, russian, example, notes ->
                viewModel.addCustomWordToBank(czech, english, russian, example, notes)
                showAddDialog = false
            }
        )
    }
}

@Composable
private fun BankWordCard(
    item: VocabularyBankEntity,
    studentLang: String,
    onSpeak: () -> Unit,
    onToggleLearned: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (item.isLearned) SecondaryEmeraldLight.copy(alpha = 0.4f) else MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(
            1.dp,
            if (item.isLearned) SecondaryEmeraldAccent.copy(alpha = 0.5f) else Slate200
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
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
                        text = item.czech,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    IconButton(
                        onClick = onSpeak,
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.VolumeUp,
                            contentDescription = "Poslech",
                            tint = PrimaryIndigo,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onToggleLearned,
                        modifier = Modifier.size(34.dp)
                    ) {
                        Icon(
                            imageVector = if (item.isLearned) Icons.Default.Check else Icons.Outlined.CheckCircle,
                            contentDescription = if (item.isLearned) "Zvládnuto" else "Označit jako zvládnuté",
                            tint = if (item.isLearned) SecondaryEmerald else Slate400
                        )
                    }
                    IconButton(
                        onClick = onDelete,
                        modifier = Modifier.size(34.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Smazat z banky",
                            tint = Rose600.copy(alpha = 0.7f),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Bilingual translations
            Row(modifier = Modifier.fillMaxWidth()) {
                if (item.english.isNotBlank()) {
                    Text(
                        text = "🇬🇧 ${item.english}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Slate700,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                }
                if (item.russian.isNotBlank()) {
                    Text(
                        text = "🇷🇺 ${item.russian}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Slate700,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            if (item.example.isNotBlank()) {
                Spacer(modifier = Modifier.height(6.dp))
                Surface(
                    color = Color(0xFFFFF7ED),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFFFED7AA)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "„${item.example}“",
                        style = MaterialTheme.typography.bodySmall,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Medium,
                        color = DoodleBlack,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            if (item.notes.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Poznámka: ${item.notes}",
                    style = MaterialTheme.typography.labelSmall,
                    color = Slate600
                )
            }
        }
    }
}

@Composable
private fun BankFlashcardPractice(
    items: List<VocabularyBankEntity>,
    studentLang: String,
    onSpeak: (String) -> Unit,
    onMarkLearned: (String) -> Unit,
    onClose: () -> Unit
) {
    var cardIndex by remember { mutableIntStateOf(0) }
    var isFlipped by remember { mutableStateOf(false) }

    val currentItem = items[cardIndex.coerceIn(items.indices)]

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = PrimaryLight),
        border = BorderStroke(2.dp, PrimaryIndigo),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "🎴 Kartičky z banky (${cardIndex + 1} / ${items.size})",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryIndigo
                )
                IconButton(onClick = onClose, modifier = Modifier.size(28.dp)) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "Zavřít trénink")
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Surface(
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.surface,
                shadowElevation = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isFlipped = !isFlipped }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = currentItem.czech,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center
                    )

                    IconButton(
                        onClick = { onSpeak(currentItem.czech) },
                        modifier = Modifier.padding(top = 6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.VolumeUp,
                            contentDescription = "Výslovnost",
                            tint = PrimaryIndigo
                        )
                    }

                    if (!isFlipped) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Klepněte pro zobrazení překladu 👆",
                            style = MaterialTheme.typography.labelSmall,
                            color = Slate600
                        )
                    } else {
                        Spacer(modifier = Modifier.height(12.dp))
                        if (currentItem.english.isNotBlank()) {
                            Text(
                                text = "🇬🇧 ${currentItem.english}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Slate800
                            )
                        }
                        if (currentItem.russian.isNotBlank()) {
                            Text(
                                text = "🇷🇺 ${currentItem.russian}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Slate800,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                        if (currentItem.example.isNotBlank()) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "„${currentItem.example}“",
                                style = MaterialTheme.typography.bodySmall,
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Medium,
                                color = DoodleBlack,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        isFlipped = false
                        if (cardIndex < items.size - 1) cardIndex++ else cardIndex = 0
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Přeskočit →")
                }

                Button(
                    onClick = {
                        onMarkLearned(currentItem.id)
                        isFlipped = false
                        if (cardIndex < items.size - 1) cardIndex++ else cardIndex = 0
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = SecondaryEmerald),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("✓ Zvládnuto!")
                }
            }
        }
    }
}

@Composable
private fun AddCustomWordDialog(
    onDismiss: () -> Unit,
    onAddWord: (czech: String, english: String, russian: String, example: String, notes: String) -> Unit
) {
    var czech by remember { mutableStateOf("") }
    var english by remember { mutableStateOf("") }
    var russian by remember { mutableStateOf("") }
    var example by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Přidat slovo do banky") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = czech,
                    onValueChange = { czech = it },
                    label = { Text("České slovo / fráze *") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = english,
                    onValueChange = { english = it },
                    label = { Text("🇬🇧 Anglický překlad (AJ)") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = russian,
                    onValueChange = { russian = it },
                    label = { Text("🇷🇺 Ruský překlad (RJ)") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = example,
                    onValueChange = { example = it },
                    label = { Text("Příkladová věta") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text("Vlastní poznámka") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (czech.isNotBlank()) {
                        onAddWord(czech, english, russian, example, notes)
                    }
                },
                enabled = czech.isNotBlank()
            ) {
                Text("Uložit do banky")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Zrušit")
            }
        }
    )
}
