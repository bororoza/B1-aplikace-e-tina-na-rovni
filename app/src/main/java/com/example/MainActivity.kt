package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.CurrentScreen
import com.example.ui.MainViewModel
import com.example.ui.screens.StudentProgressScreen
import com.example.ui.screens.TopicDetailScreen
import com.example.ui.screens.TopicListScreen
import com.example.ui.screens.VocabularyBankScreen
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val viewModel: MainViewModel = viewModel()
                val currentScreen by viewModel.currentScreen.collectAsState()
                val selectedTopic by viewModel.selectedTopic.collectAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.White
                ) { innerPadding ->
                    when (currentScreen) {
                        CurrentScreen.TOPIC_DETAIL -> {
                            if (selectedTopic != null) {
                                BackHandler {
                                    viewModel.selectTopic(null)
                                }
                                TopicDetailScreen(
                                    topic = selectedTopic!!,
                                    viewModel = viewModel,
                                    onBack = { viewModel.selectTopic(null) },
                                    modifier = Modifier.padding(innerPadding)
                                )
                            } else {
                                viewModel.navigateTo(CurrentScreen.TOPICS_LIST)
                            }
                        }
                        CurrentScreen.VOCABULARY_BANK -> {
                            BackHandler {
                                viewModel.navigateTo(CurrentScreen.TOPICS_LIST)
                            }
                            VocabularyBankScreen(
                                viewModel = viewModel,
                                onBack = { viewModel.navigateTo(CurrentScreen.TOPICS_LIST) },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        CurrentScreen.STUDENT_PROGRESS -> {
                            BackHandler {
                                viewModel.navigateTo(CurrentScreen.TOPICS_LIST)
                            }
                            StudentProgressScreen(
                                viewModel = viewModel,
                                onTopicSelected = { topic ->
                                    viewModel.selectTopic(topic)
                                },
                                onBack = { viewModel.navigateTo(CurrentScreen.TOPICS_LIST) },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        CurrentScreen.TOPICS_LIST -> {
                            TopicListScreen(
                                viewModel = viewModel,
                                onTopicSelected = { topic ->
                                    viewModel.selectTopic(topic)
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}

