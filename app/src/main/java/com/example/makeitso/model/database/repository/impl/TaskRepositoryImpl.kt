package com.example.makeitso.model.database.repository.impl

import com.example.makeitso.model.Task
import com.example.makeitso.model.database.dao.TaskDao
import com.example.makeitso.model.database.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(private val taskDao: TaskDao) : TaskRepository {
    override suspend fun insert(task: Task) {
        Dispatchers.IO.apply { taskDao.insert(task) }
    }

    override suspend fun delete(taskId: Long) {
        Dispatchers.IO.apply { taskDao.delete(taskId) }
    }

    override suspend fun getById(id: Long): Task {
        return taskDao.getById(id)
    }

    override suspend fun getAllForUser(userId: String): List<Task> {
        return taskDao.getAllForUser(userId)
    }

    override suspend fun updateCompletion(taskId: Long, isComplete: Boolean) {
        Dispatchers.IO.apply { taskDao.updateCompletion(isComplete, taskId) }
    }

    override suspend fun updateFlag(taskId: Long, hasFlag: Boolean) {
        Dispatchers.IO.apply { taskDao.updateFlag(hasFlag, taskId) }
    }
}
