package com.example.ui.screens.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.MainViewModel
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.theme.Rose600
import com.example.ui.theme.SecondaryEmerald

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PuzzleTab(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val puzzles by viewModel.puzzles.collectAsState()
    val activeIndex by viewModel.activePuzzleIndex.collectAsState()
    val selectedTokens by viewModel.selectedTokens.collectAsState()
    val showHint by viewModel.showHint.collectAsState()

    if (puzzles.isEmpty()) {
        Box(
            modifier = modifier.padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Žádné věty k procvičování pro toto téma.")
        }
        return
    }

    val currentPuzzle = puzzles.getOrNull(activeIndex) ?: puzzles.first()
    val isCompleted = selectedTokens.size == currentPuzzle.tokens.size
    val isCorrect = isCompleted && selectedTokens == currentPuzzle.tokens

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Navigation and header card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(18.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { viewModel.selectPuzzleIndex(activeIndex - 1) },
                    enabled = activeIndex > 0
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Předchozí věta")
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Věta ${activeIndex + 1} z ${puzzles.size}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Syntaktický dril slovosledu",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = { viewModel.selectPuzzleIndex(activeIndex + 1) },
                    enabled = activeIndex < puzzles.size - 1
                ) {
                    Icon(Icons.Default.ArrowForward, contentDescription = "Další věta")
                }
            }
        }

        // Sentence Target Slot Box
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(18.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            ) {
                Text(
                    text = "Sestavená věta (kliknutím odeberete slovo):",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                        .border(
                            width = 1.5.dp,
                            color = if (isCompleted) {
                                if (isCorrect) SecondaryEmerald else Rose600
                            } else {
                                MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                            },
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(12.dp)
                ) {
                    if (selectedTokens.isEmpty()) {
                        Text(
                            text = "Klikejte na slova níže ve správném pořadí...",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                            modifier = Modifier.padding(vertical = 14.dp)
                        )
                    } else {
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            selectedTokens.forEachIndexed { index, token ->
                                Surface(
                                    color = PrimaryIndigo,
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .clickable { viewModel.removePuzzleTokenAt(index) }
                                ) {
                                    Text(
                                        text = token,
                                        style = MaterialTheme.typography.labelLarge,
                                        fontWeight = FontWeight.Medium,
                                        color = Color.White,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                    )
                                }
                            }
                        }
                    }
                }

                // Result feedback banner
                if (isCompleted) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (isCorrect) {
                            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = SecondaryEmerald)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "✓ Výborně! Správně sestaveno podle pravidel české syntaxe.",
                                color = SecondaryEmerald,
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                        } else {
                            Text(
                                text = "✗ Nesprávný slovosled. Zkontrolujte pozici sloves a spojek.",
                                color = Rose600,
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                // Hint box if toggled
                if (showHint) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Surface(
                        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Nápověda: \"${currentPuzzle.originalSentence}\"",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }

        // Word choices pool
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(18.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            ) {
                Text(
                    text = "Dostupná slova k výběru:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Count used occurrences
                val usedMap = mutableMapOf<String, Int>()
                selectedTokens.forEach { token ->
                    usedMap[token] = (usedMap[token] ?: 0) + 1
                }

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val availableTokens = currentPuzzle.shuffledTokens.toMutableList()
                    // Filter out already used items one by one
                    val tempUsed = usedMap.toMutableMap()
                    val remainingTokens = mutableListOf<String>()
                    availableTokens.forEach { token ->
                        val count = tempUsed[token] ?: 0
                        if (count > 0) {
                            tempUsed[token] = count - 1
                        } else {
                            remainingTokens.add(token)
                        }
                    }

                    remainingTokens.forEach { token ->
                        OutlinedButton(
                            onClick = { viewModel.addPuzzleToken(token) },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.testTag("puzzle_token_$token")
                        ) {
                            Text(
                                text = token,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = { viewModel.toggleHint() }
                    ) {
                        Icon(Icons.Default.HelpOutline, contentDescription = null)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(if (showHint) "Skrýt nápovědu" else "Nápověda")
                    }

                    FilledTonalButton(
                        onClick = { viewModel.resetCurrentPuzzle() }
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Resetovat větu")
                    }
                }
            }
        }
    }
}
