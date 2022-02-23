package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.TestCase
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.`is`
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_CompletedTasks_returnsZeroActiveHundredCompleted() {
        // Create an active task
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent,  `is`(100f) )
        assertThat(result.activeTasksPercent,`is`(0f))

    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        // Create an active task
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent,  `is`(40f) )
        assertThat(result.activeTasksPercent,`is`(60f))

    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroCompletedHundredActive() {
        // Create an active task
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent,  `is`(0f) )
        assertThat(result.activeTasksPercent,`is`(100f))

    }


    @Test
    fun getActiveAndCompletedStats_nullList_returnsZeros() {
        // Create an active task
        val tasks = null

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent,  `is`(0f) )
        assertThat(result.activeTasksPercent,`is`(0f))

    }

    @Test
    fun getActiveAndCompletedStats_emptyList_returnsZeros() {
        // Create an active task
        val tasks = emptyList<Task>()

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent,  `is`(0f) )
        assertThat(result.activeTasksPercent,`is`(0f))

    }

}