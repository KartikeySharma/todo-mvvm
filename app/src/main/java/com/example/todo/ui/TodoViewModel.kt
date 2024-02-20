package com.example.todo.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todo.data.TodoRepository
import com.example.todo.data.db.Todo
import com.example.todo.data.db.TodoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {

    val allTodos: LiveData<List<Todo>>
    var repository: TodoRepository

    init {
        val todoDao = TodoDatabase.getDatabase(application).getTodoDao()
        repository = TodoRepository(todoDao)
        allTodos = repository.allTodos
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO){
        repository.update(todo)
    }

    fun addTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(todo)
    }

    fun deleteTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(todo)
    }
}