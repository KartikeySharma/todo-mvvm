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
        Log.d("TodoRepository", "Updating Todo: $todo")
        todoDao.update(todo)
        Log.d("TodoRepository", "Todo updated successfully")
    }
}