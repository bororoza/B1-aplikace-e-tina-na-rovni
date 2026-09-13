package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.TopicsRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Čeština na úrovni B1", appName)
  }

  @Test
  fun `verify thirty topics loaded`() {
    val topics = TopicsRepository.allTopics
    assertEquals(30, topics.size)
    topics.forEach { topic ->
      assertTrue(topic.title.isNotBlank())
      assertTrue(topic.text.isNotEmpty())
      assertEquals(4, topic.associationMap.size)
      assertEquals(4, topic.examCards.size)
      val puzzles = TopicsRepository.generatePuzzlesForTopic(topic)
      assertTrue(puzzles.isNotEmpty())
    }
  }
}

