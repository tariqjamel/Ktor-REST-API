package com.example.model

object TaskRepository {
    private val tasks = mutableListOf(
        Task("reading", "Read a chapter of the book", Priority.Medium),
        Task("coding", "make an app", Priority.High),
        Task("organizing", "Organize the closet", Priority.Medium),
        Task("car wash", "Wash the car", Priority.Low),
        Task("email", "Respond to work emails", Priority.High),
        Task("workout", "Go to the gym", Priority.Medium),
        Task("meeting", "Attend the project meeting", Priority.High),
        Task("bill payment", "Pay the electricity bill", Priority.High)
    )

    fun allTasks(): List<Task> = tasks

    fun tasksByPriority(priority: Priority) = tasks.filter {
        it.priority == priority
    }

    fun taskByName(name: String) = tasks.find {
        it.name.equals(name, ignoreCase = true)
    }

    fun addTask(task: Task) {
        if (taskByName(task.name) != null) {
            throw IllegalStateException("Cannot duplicate task names!")
        }
        tasks.add(task)
    }

    fun removeTask(name: String): Boolean {
        return tasks.removeIf { it.name == name }
    }
}

