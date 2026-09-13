package com.example.data

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("b1_trainer_prefs", Context.MODE_PRIVATE)

    fun getFavorites(): Set<String> {
        return prefs.getStringSet("favorites", emptySet()) ?: emptySet()
    }

    fun toggleFavorite(topicId: String): Boolean {
        val current = getFavorites().toMutableSet()
        val isNowFavorite = if (current.contains(topicId)) {
            current.remove(topicId)
            false
        } else {
            current.add(topicId)
            true
        }
        prefs.edit().putStringSet("favorites", current).apply()
        return isNowFavorite
    }

    fun getMasteredTopics(): Set<String> {
        return prefs.getStringSet("mastered_topics", emptySet()) ?: emptySet()
    }

    fun toggleMasteredTopic(topicId: String): Boolean {
        val current = getMasteredTopics().toMutableSet()
        val isNowMastered = if (current.contains(topicId)) {
            current.remove(topicId)
            false
        } else {
            current.add(topicId)
            true
        }
        prefs.edit().putStringSet("mastered_topics", current).apply()
        return isNowMastered
    }

    fun getMasteredCards(): Set<String> {
        return prefs.getStringSet("mastered_cards", emptySet()) ?: emptySet()
    }

    fun toggleMasteredCard(cardKey: String): Boolean {
        val current = getMasteredCards().toMutableSet()
        val isNowMastered = if (current.contains(cardKey)) {
            current.remove(cardKey)
            false
        } else {
            current.add(cardKey)
            true
        }
        prefs.edit().putStringSet("mastered_cards", current).apply()
        return isNowMastered
    }

    fun getActiveStudentId(): String? {
        return prefs.getString("active_student_id", null)
    }

    fun setActiveStudentId(id: String) {
        prefs.edit().putString("active_student_id", id).apply()
    }
}
