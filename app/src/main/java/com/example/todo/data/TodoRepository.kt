package com.example.todo.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.todo.data.db.Todo
import com.example.todo.data.db.TodoDao

class TodoRepository(private val todoDao: TodoDao) {
    val allTodos: LiveData<List<Todo>> = todoDao.getAllTodo()

    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }
    suspend fun update(todo: Todo) {
        todoDao.update(todo)
    }

    suspend fun delete(todo: Todo) {
        todoDao.delete(todo)
    }
}