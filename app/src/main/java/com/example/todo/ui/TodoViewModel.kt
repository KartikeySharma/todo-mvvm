package com.example.todo.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.TodoRepository
import com.example.todo.data.db.Todo
import com.example.todo.data.db.TodoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {

    val allTodos: LiveData<List<Todo>>
    private val repository: TodoRepository

    init {
        val todoDao = TodoDatabase.getDatabase(application).getTodoDao()
        repository = TodoRepository(todoDao)
        allTodos = repository.allTodos
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO){
        Log.d("TodoViewModel", "Updating Todo: $todo")
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(todo)
            Log.d("TodoViewModel", "Todo updated successfully")
        }
    }

    fun addTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(todo)
    }
}