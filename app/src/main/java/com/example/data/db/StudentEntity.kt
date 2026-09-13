package com.example.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey val id: String,
    val name: String,
    val preferredLanguage: String = "EN", // "EN" or "RU"
    val goal: String = "Ústní zkouška B1",
    val createdAt: Long = System.currentTimeMillis()
)
