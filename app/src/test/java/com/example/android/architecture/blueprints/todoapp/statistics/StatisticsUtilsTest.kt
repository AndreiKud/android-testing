package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    /**
     * List with single active task.
     * Results should be 100% active and 0% completed.
     */
    @Test
    fun getActiveAndCompletedStats_noCompleted_hundredActive() {
        val tasks = listOf(
            Task("title", "desc", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    /**
     * List with three active tasks and two completed.
     * Results should be 60% active and 40% completed.
     */
    @Test
    fun getActiveAndCompletedStats_both_fortySixty() {
        val tasks = listOf(
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
        )
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f, result.activeTasksPercent)
    }

}