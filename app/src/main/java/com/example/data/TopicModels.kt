package com.example.data

data class AssociationNode(
    val title: String,
    val icon: String,
    val subtitle: String,
    val bullets: List<String>
)

data class ExamCard(
    val q: String,
    val sub: String,
    val tags: List<String>,
    val tip: String? = null
)

data class KeyWord(
    val id: String,
    val czech: String,
    val english: String,
    val russian: String,
    val example: String,
    val exampleEn: String,
    val exampleRu: String,
    val clozeSentence: String = "",
    val clozeOptions: List<String> = emptyList()
)

data class Topic(
    val id: String,
    val title: String,
    val icon: String,
    val category: String,
    val text: List<String>,
    val syntacticConstructions: List<String>,
    val lexicalPhrases: List<String>,
    val recommendations: String,
    val associationMap: List<AssociationNode>,
    val examCards: List<ExamCard>,
    val keyWords: List<KeyWord> = emptyList()
)

data class SentencePuzzle(
    val id: Int,
    val originalSentence: String,
    val tokens: List<String>,
    val shuffledTokens: List<String>
)
