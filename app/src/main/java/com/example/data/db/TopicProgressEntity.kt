package com.example.data.db

import androidx.room.Entity

@Entity(
    tableName = "topic_progress",
    primaryKeys = ["studentId", "topicId"]
)
data class TopicProgressEntity(
    val studentId: String,
    val topicId: String,
    val isMastered: Boolean = false,
    val isFavorite: Boolean = false,
    val analysisDone: Boolean = false,
    val vocabMatchDone: Boolean = false,
    val vocabClozeDone: Boolean = false,
    val vanishingDone: Boolean = false,
    val puzzleDone: Boolean = false,
    val outlineDone: Boolean = false,
    val masteredCards: String = "", // e.g. "0,1,3"
    val lastUpdated: Long = System.currentTimeMillis()
)
