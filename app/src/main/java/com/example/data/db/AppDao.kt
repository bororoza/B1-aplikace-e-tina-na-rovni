package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    // Students
    @Query("SELECT * FROM students ORDER BY createdAt ASC")
    fun getAllStudents(): Flow<List<StudentEntity>>

    @Query("SELECT * FROM students WHERE id = :id LIMIT 1")
    suspend fun getStudentById(id: String): StudentEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: StudentEntity)

    @Query("DELETE FROM students WHERE id = :id")
    suspend fun deleteStudent(id: String)

    // Topic Progress
    @Query("SELECT * FROM topic_progress WHERE studentId = :studentId")
    fun getProgressForStudent(studentId: String): Flow<List<TopicProgressEntity>>

    @Query("SELECT * FROM topic_progress WHERE studentId = :studentId AND topicId = :topicId LIMIT 1")
    suspend fun getProgressForTopic(studentId: String, topicId: String): TopicProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateProgress(progress: TopicProgressEntity)

    // Vocabulary Bank
    @Query("SELECT * FROM vocabulary_bank WHERE studentId = :studentId ORDER BY addedAt DESC")
    fun getBankForStudent(studentId: String): Flow<List<VocabularyBankEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVocabularyItem(item: VocabularyBankEntity)

    @Query("UPDATE vocabulary_bank SET isLearned = :isLearned WHERE id = :id")
    suspend fun updateVocabularyLearnedStatus(id: String, isLearned: Boolean)

    @Query("DELETE FROM vocabulary_bank WHERE id = :id")
    suspend fun deleteVocabularyItem(id: String)
}
