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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Warning
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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.Topic
import com.example.data.TopicsRepository
import com.example.data.db.StudentEntity
import com.example.ui.MainViewModel
import com.example.ui.theme.AccentAmber
import com.example.ui.theme.AccentAmberLight
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.theme.PrimaryLight
import com.example.ui.theme.SecondaryEmerald
import com.example.ui.theme.SecondaryEmeraldAccent
import com.example.ui.theme.SecondaryEmeraldLight
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate400
import com.example.ui.theme.Slate500
import com.example.ui.theme.Slate600
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate800

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentProgressScreen(
    viewModel: MainViewModel,
    onTopicSelected: (Topic) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activeStudent by viewModel.activeStudent.collectAsState()
    val allStudents by viewModel.allStudents.collectAsState()
    val studentProgressMap by viewModel.studentProgressMap.collectAsState()
    val vocabularyBank by viewModel.vocabularyBank.collectAsState()

    var showRegisterDialog by remember { mutableStateOf(false) }
    var showSwitchDialog by remember { mutableStateOf(false) }
    var filterMode by remember { mutableStateOf("ALL") } // ALL, COMPLETED, NEEDS_WORK

    val allTopics = TopicsRepository.allTopics
    val totalTopicsCount = allTopics.size

    val completedCount = allTopics.count { topic ->
        val p = studentProgressMap[topic.id]
        p?.isMastered == true || (
                p?.analysisDone == true &&
                p.vocabMatchDone &&
                p.vocabClozeDone &&
                p.puzzleDone
        )
    }

    val progressFraction = (completedCount.toFloat() / totalTopicsCount.coerceAtLeast(1)).coerceIn(0f, 1f)

    val filteredTopics = remember(allTopics, studentProgressMap, filterMode) {
        when (filterMode) {
            "COMPLETED" -> allTopics.filter {
                val p = studentProgressMap[it.id]
                p?.isMastered == true || (p?.analysisDone == true && p.vocabMatchDone && p.vocabClozeDone && p.puzzleDone)
            }
            "NEEDS_WORK" -> allTopics.filter {
                val p = studentProgressMap[it.id]
                !(p?.isMastered == true || (p?.analysisDone == true && p.vocabMatchDone && p.vocabClozeDone && p.puzzleDone))
            }
            else -> allTopics
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profil studenta & Pokrok",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
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
                    IconButton(onClick = { showSwitchDialog = true }) {
                        Icon(
                            imageVector = Icons.Default.SwapHoriz,
                            contentDescription = "Přepnout studenta",
                            tint = PrimaryIndigo
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
                .testTag("student_progress_screen"),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Student Profile Header Card
            item {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.5.dp, PrimaryLight),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f)
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = PrimaryIndigo,
                                    modifier = Modifier.size(48.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text(
                                            text = (activeStudent?.name?.firstOrNull() ?: 'S').toString().uppercase(),
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 20.sp
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.width(12.dp))

                                Column {
                                    Text(
                                        text = activeStudent?.name ?: "Student",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = if (activeStudent?.preferredLanguage == "RU") "🇷🇺 Ruský mluvčí" else "🇬🇧 Anglický mluvčí",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = Slate600
                                        )
                                        Text(" • ", color = Slate400)
                                        Text(
                                            text = activeStudent?.goal ?: "B1 zkouška",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = PrimaryIndigo,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    }
                                }
                            }

                            OutlinedButton(
                                onClick = { showRegisterDialog = true },
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Registrace", style = MaterialTheme.typography.labelSmall)
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Progress overview
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Celkový pokrok v tématech B1",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = Slate700
                            )
                            Text(
                                text = "$completedCount z $totalTopicsCount (${(progressFraction * 100).toInt()}%)",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = SecondaryEmerald
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        LinearProgressIndicator(
                            progress = { progressFraction },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = SecondaryEmerald,
                            trackColor = Slate200
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        // Quick Stats Grid
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Surface(
                                color = PrimaryLight,
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text("Banka slovíček", style = MaterialTheme.typography.labelSmall, color = Slate600)
                                    Text(
                                        text = "${vocabularyBank.count { !it.isLearned }} k naučení",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = PrimaryIndigo
                                    )
                                }
                            }

                            Surface(
                                color = SecondaryEmeraldLight,
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text("Naučená slova", style = MaterialTheme.typography.labelSmall, color = Slate600)
                                    Text(
                                        text = "${vocabularyBank.count { it.isLearned }} zvládnuto",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = SecondaryEmerald
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Topics Breakdown Section Header & Filters
            item {
                Column {
                    Text(
                        text = "Stav jednotlivých témat a cvičení",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Slate800
                    )
                    Text(
                        text = "Přehled splněných cvičení a témat, na kterých je potřeba zapracovat:",
                        style = MaterialTheme.typography.bodySmall,
                        color = Slate600,
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FilterChip(
                            selected = filterMode == "ALL",
                            onClick = { filterMode = "ALL" },
                            label = { Text("Všechna (${allTopics.size})") }
                        )
                        FilterChip(
                            selected = filterMode == "COMPLETED",
                            onClick = { filterMode = "COMPLETED" },
                            label = { Text("Splněno ($completedCount)") },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = SecondaryEmeraldLight,
                                selectedLabelColor = SecondaryEmerald
                            )
                        )
                        FilterChip(
                            selected = filterMode == "NEEDS_WORK",
                            onClick = { filterMode = "NEEDS_WORK" },
                            label = { Text("Zapracovat (${totalTopicsCount - completedCount})") },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = AccentAmberLight,
                                selectedLabelColor = AccentAmber
                            )
                        )
                    }
                }
            }

            // Topic Cards List
            items(filteredTopics, key = { it.id }) { topic ->
                val progress = studentProgressMap[topic.id]
                val isMastered = progress?.isMastered == true || (
                        progress?.analysisDone == true &&
                        progress.vocabMatchDone &&
                        progress.vocabClozeDone &&
                        progress.puzzleDone
                )

                val missingList = mutableListOf<String>()
                if (progress?.analysisDone != true) missingList.add("Analýza")
                if (progress?.vocabMatchDone != true) missingList.add("Spojování")
                if (progress?.vocabClozeDone != true) missingList.add("Doplňování")
                if (progress?.vanishingDone != true) missingList.add("Zmizík")
                if (progress?.puzzleDone != true) missingList.add("Puzzle")

                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isMastered) SecondaryEmeraldLight.copy(alpha = 0.35f) else MaterialTheme.colorScheme.surface
                    ),
                    border = BorderStroke(
                        1.dp,
                        if (isMastered) SecondaryEmeraldAccent.copy(alpha = 0.5f) else Slate200
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onTopicSelected(topic) }
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
                                Text(topic.icon, fontSize = 22.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = topic.title,
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = topic.category,
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Slate500
                                    )
                                }
                            }

                            if (isMastered) {
                                Surface(
                                    color = SecondaryEmerald,
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Icon(imageVector = Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Splněno", color = Color.White, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
                                    }
                                }
                            } else {
                                Surface(
                                    color = AccentAmberLight,
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Icon(imageVector = Icons.Default.Warning, contentDescription = null, tint = AccentAmber, modifier = Modifier.size(14.dp))
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Zapracovat", color = AccentAmber, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Exercise Checklist Pills
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            ExerciseStatusChip("🔍 Analýza", progress?.analysisDone == true)
                            ExerciseStatusChip("📚 Slovíčka", (progress?.vocabMatchDone == true || progress?.vocabClozeDone == true))
                            ExerciseStatusChip("👁️ Zmizík", progress?.vanishingDone == true)
                            ExerciseStatusChip("🧩 Puzzle", progress?.puzzleDone == true)
                            ExerciseStatusChip("🎴 Stimuly", (progress?.masteredCards?.isNotBlank() == true))
                        }

                        if (!isMastered && missingList.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Ještě procvičit: ${missingList.take(3).joinToString(", ")}",
                                style = MaterialTheme.typography.labelSmall,
                                color = Slate600
                            )
                        }
                    }
                }
            }
        }
    }

    // Register Dialog
    if (showRegisterDialog) {
        RegisterStudentDialog(
            onDismiss = { showRegisterDialog = false },
            onRegister = { name, lang, goal ->
                viewModel.registerStudent(name, lang, goal)
                showRegisterDialog = false
            }
        )
    }

    // Switch Student Dialog
    if (showSwitchDialog) {
        SwitchStudentDialog(
            students = allStudents,
            activeStudentId = activeStudent?.id ?: "",
            onDismiss = { showSwitchDialog = false },
            onSelectStudent = { id ->
                viewModel.switchStudent(id)
                showSwitchDialog = false
            },
            onOpenRegister = {
                showSwitchDialog = false
                showRegisterDialog = true
            }
        )
    }
}

@Composable
private fun ExerciseStatusChip(label: String, isDone: Boolean) {
    Surface(
        color = if (isDone) SecondaryEmeraldLight else Slate200.copy(alpha = 0.6f),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            text = if (isDone) "✓ $label" else label,
            color = if (isDone) SecondaryEmerald else Slate600,
            style = MaterialTheme.typography.labelSmall,
            fontSize = 10.sp,
            fontWeight = if (isDone) FontWeight.Bold else FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
        )
    }
}

@Composable
private fun RegisterStudentDialog(
    onDismiss: () -> Unit,
    onRegister: (name: String, language: String, goal: String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var language by remember { mutableStateOf("EN") } // EN or RU
    var goal by remember { mutableStateOf("Ústní zkouška B1") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Registrace nového studenta") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Jméno nebo přezdívka *") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Text("Preferovaný jazyk překladů:", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = language == "EN",
                        onClick = { language = "EN" },
                        label = { Text("🇬🇧 English (AJ)") },
                        modifier = Modifier.weight(1f)
                    )
                    FilterChip(
                        selected = language == "RU",
                        onClick = { language = "RU" },
                        label = { Text("🇷🇺 Русский (RJ)") },
                        modifier = Modifier.weight(1f)
                    )
                }

                OutlinedTextField(
                    value = goal,
                    onValueChange = { goal = it },
                    label = { Text("Cíl studia") },
                    placeholder = { Text("např. Zkouška B1, Občanství, Univerzita") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        onRegister(name.trim(), language, goal.trim())
                    }
                },
                enabled = name.isNotBlank()
            ) {
                Text("Zaregistrovat")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Zrušit")
            }
        }
    )
}

@Composable
private fun SwitchStudentDialog(
    students: List<StudentEntity>,
    activeStudentId: String,
    onDismiss: () -> Unit,
    onSelectStudent: (String) -> Unit,
    onOpenRegister: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Přepnout profil studenta") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                students.forEach { student ->
                    val isSelected = student.id == activeStudentId
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = if (isSelected) PrimaryLight else MaterialTheme.colorScheme.surface,
                        border = BorderStroke(1.dp, if (isSelected) PrimaryIndigo else Slate200),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSelectStudent(student.id) }
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = student.name,
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = "${if (student.preferredLanguage == "RU") "🇷🇺 Русский" else "🇬🇧 English"} • ${student.goal}",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Slate600
                                )
                            }
                            if (isSelected) {
                                Text("Aktivní", color = PrimaryIndigo, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelSmall)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                OutlinedButton(
                    onClick = onOpenRegister,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Přidat nového studenta")
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Zavřít")
            }
        }
    )
}
