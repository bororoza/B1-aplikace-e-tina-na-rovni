package com.example.ui.screens.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.Topic
import com.example.ui.MainViewModel
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.theme.SecondaryEmerald
import com.example.ui.theme.Slate300
import com.example.ui.theme.Slate700
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun VanishingTab(
    topic: Topic,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val maskPercent by viewModel.maskPercent.collectAsState()
    val isFirstLettersOnly by viewModel.isFirstLettersOnly.collectAsState()
    val revealedIndices by viewModel.revealedWordIndices.collectAsState()

    // Pre-calculate word structure with deterministic random masking per word index
    val paragraphsWords = remember(topic) {
        var globalIndex = 0
        topic.text.map { paragraph ->
            paragraph.split(" ").filter { it.isNotBlank() }.map { word ->
                val index = globalIndex++
                // Clean punctuation
                val cleanWord = word.replace(Regex("""[.,?\/#!$%\^&\*;:{}=\-_`~()–]"""), "")
                val punctuation = word.removePrefix(cleanWord)
                Triple(index, cleanWord, punctuation)
            }
        }
    }

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Control panel card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(18.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Metoda postupného mizení (Zmizík)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Trénujte paměť zakrýváním slov. Kliknutím na zakryté slovo ho odhalíte.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 2.dp, bottom = 12.dp)
                )

                // Filter buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = maskPercent == 0 && !isFirstLettersOnly,
                        onClick = { viewModel.setMaskPercent(0) },
                        label = { Text("Reset (0%)") }
                    )
                    FilterChip(
                        selected = maskPercent == 15 && !isFirstLettersOnly,
                        onClick = { viewModel.setMaskPercent(15) },
                        label = { Text("Mizení 15%") }
                    )
                    FilterChip(
                        selected = maskPercent == 40 && !isFirstLettersOnly,
                        onClick = { viewModel.setMaskPercent(40) },
                        label = { Text("Mizení 40%") }
                    )
                    FilterChip(
                        selected = maskPercent == 70 && !isFirstLettersOnly,
                        onClick = { viewModel.setMaskPercent(70) },
                        label = { Text("Mizení 70%") }
                    )
                    FilterChip(
                        selected = isFirstLettersOnly,
                        onClick = { viewModel.setFirstLettersOnly() },
                        label = { Text("Jen 1. písmena") }
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (revealedIndices.isNotEmpty()) "Odhaleno: ${revealedIndices.size} slov" else "Zvolte úroveň mizení výše",
                        style = MaterialTheme.typography.labelSmall,
                        color = SecondaryEmerald,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row {
                        OutlinedButton(
                            onClick = { viewModel.revealAllWords() }
                        ) {
                            Icon(imageVector = Icons.Default.Visibility, contentDescription = null)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Odhalit vše", style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
            }
        }

        // Vanishing text display card
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
                paragraphsWords.forEachIndexed { pIndex, wordsInParagraph ->
                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        wordsInParagraph.forEach { (index, cleanWord, punctuation) ->
                            val isRevealed = revealedIndices.contains(index)
                            // Pseudo-random mask based on topic and word index
                            val shouldMask = if (isFirstLettersOnly) {
                                true
                            } else {
                                val seed = (cleanWord.hashCode() + index * 31).let { if (it < 0) -it else it }
                                (seed % 100) < maskPercent
                            }

                            if (shouldMask && !isRevealed && maskPercent > 0 && !isFirstLettersOnly) {
                                // Masked block
                                Box(
                                    modifier = Modifier
                                        .padding(horizontal = 2.dp, vertical = 2.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.35f))
                                        .clickable { viewModel.revealWord(index) }
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "_".repeat(cleanWord.length.coerceAtLeast(3)),
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                                    )
                                }
                            } else if (isFirstLettersOnly && !isRevealed && cleanWord.length > 1) {
                                // First letter only with dashes
                                Box(
                                    modifier = Modifier
                                        .padding(horizontal = 2.dp, vertical = 2.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(MaterialTheme.colorScheme.surfaceVariant)
                                        .clickable { viewModel.revealWord(index) }
                                        .padding(horizontal = 4.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = cleanWord.take(1) + "_".repeat((cleanWord.length - 1).coerceAtLeast(2)),
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = PrimaryIndigo
                                    )
                                }
                            } else if (isRevealed && shouldMask) {
                                // Revealed word
                                Text(
                                    text = cleanWord,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = SecondaryEmerald,
                                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 2.dp)
                                )
                            } else {
                                // Regular word
                                Text(
                                    text = cleanWord,
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 2.dp)
                                )
                            }

                            if (punctuation.isNotBlank()) {
                                Text(
                                    text = punctuation,
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.padding(end = 4.dp)
                                )
                            } else {
                                Spacer(modifier = Modifier.width(3.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
