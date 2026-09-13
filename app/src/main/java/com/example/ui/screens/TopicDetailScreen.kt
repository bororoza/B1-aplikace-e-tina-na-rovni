package com.example.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.Topic
import com.example.ui.MainViewModel
import com.example.ui.TrainerTab
import com.example.ui.components.LogoPuzzleMiniBadge
import com.example.ui.screens.tabs.AnalysisTab
import com.example.ui.screens.tabs.AssociationMapTab
import com.example.ui.screens.tabs.ExamCardsTab
import com.example.ui.screens.tabs.PuzzleTab
import com.example.ui.screens.tabs.VanishingTab
import com.example.ui.screens.tabs.VocabularyTab
import com.example.ui.theme.LogoPink
import com.example.ui.theme.LogoYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicDetailScreen(
    topic: Topic,
    viewModel: MainViewModel,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activeTab by viewModel.activeTab.collectAsState()
    val favorites by viewModel.favorites.collectAsState()
    val masteredTopics by viewModel.masteredTopics.collectAsState()
    val isFavorite = favorites.contains(topic.id)
    val isMastered = masteredTopics.contains(topic.id)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        LogoPuzzleMiniBadge()
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(topic.icon, fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = topic.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Zpět na seznam témat"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.toggleMasteredTopic(topic.id) }) {
                        Icon(
                            imageVector = if (isMastered) Icons.Default.CheckCircle else Icons.Outlined.CheckCircleOutline,
                            contentDescription = "Zvládnuto",
                            tint = if (isMastered) LogoYellow else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    IconButton(onClick = { viewModel.toggleFavorite(topic.id) }) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Oblíbené",
                            tint = if (isFavorite) LogoPink else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 6 Practice Mode Tabs styled with logo colors
            PrimaryScrollableTabRow(
                selectedTabIndex = activeTab.ordinal,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("practice_tabs"),
                edgePadding = 12.dp
            ) {
                TrainerTab.entries.forEach { tab ->
                    val isSelected = activeTab == tab
                    Tab(
                        selected = isSelected,
                        onClick = { viewModel.selectTab(tab) },
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(tab.icon, fontSize = 14.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = tab.title,
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = if (isSelected) FontWeight.Black else FontWeight.Medium,
                                    color = if (isSelected) LogoPink else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    )
                }
            }

            // Tab Content
            when (activeTab) {
                TrainerTab.ANALYSIS -> AnalysisTab(topic = topic, viewModel = viewModel)
                TrainerTab.VOCABULARY -> VocabularyTab(topic = topic, viewModel = viewModel)
                TrainerTab.VANISHING -> VanishingTab(topic = topic, viewModel = viewModel)
                TrainerTab.PUZZLE -> PuzzleTab(viewModel = viewModel)
                TrainerTab.KEYWORDS -> AssociationMapTab(topic = topic)
                TrainerTab.PROMPTS -> ExamCardsTab(topic = topic, viewModel = viewModel)
            }
        }
    }
}
