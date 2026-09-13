package com.example.data

object TopicsRepository {
    val allTopics: List<Topic> by lazy {
        (topicsPart1 + topicsPart2).map { topic ->
            topic.copy(keyWords = TopicVocabularyRepository.getKeyWords(topic.id))
        }
    }

    val categories: List<String> by lazy {
        listOf("Všechna témata") + allTopics.map { it.category }.distinct()
    }

    fun getTopicById(id: String): Topic? {
        return allTopics.find { it.id == id }
    }

    fun generatePuzzlesForTopic(topic: Topic): List<SentencePuzzle> {
        val rawSentences = mutableListOf<String>()
        topic.text.forEach { paragraph ->
            val regex = Regex("""[^.!?]+[.!?]+""")
            regex.findAll(paragraph).forEach { match ->
                val trimmed = match.value.trim().replace(Regex("""\s+"""), " ")
                val wordCount = trimmed.split(" ").size
                if (wordCount in 4..14) {
                    rawSentences.add(trimmed)
                }
            }
        }

        val targetList = if (rawSentences.size >= 8) {
            val step = rawSentences.size / 8
            (0 until 8).map { rawSentences[it * step] }
        } else if (rawSentences.isNotEmpty()) {
            rawSentences.take(8)
        } else {
            listOf(topic.text.firstOrNull() ?: "Moře a hory jsou oblíbená místa pro dovolenou.")
        }

        return targetList.mapIndexed { index, sentence ->
            val cleanTokens = sentence.split(" ").filter { it.isNotBlank() }
            val shuffled = cleanTokens.shuffled().toMutableList()
            if (shuffled == cleanTokens && cleanTokens.size > 1) {
                shuffled.reverse()
            }
            SentencePuzzle(
                id = index + 1,
                originalSentence = sentence,
                tokens = cleanTokens,
                shuffledTokens = shuffled
            )
        }
    }
}
