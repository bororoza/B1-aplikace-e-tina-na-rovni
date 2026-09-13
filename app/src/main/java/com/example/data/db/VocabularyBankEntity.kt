package com.example.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vocabulary_bank")
data class VocabularyBankEntity(
    @PrimaryKey val id: String,
    val studentId: String,
    val topicId: String = "",
    val czech: String,
    val english: String,
    val russian: String,
    val example: String = "",
    val exampleEn: String = "",
    val exampleRu: String = "",
    val isLearned: Boolean = false,
    val addedAt: Long = System.currentTimeMillis(),
    val notes: String = ""
)
