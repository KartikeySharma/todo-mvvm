package com.example.todo.ui

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.adapter.TodoAdapter
import com.example.todo.data.db.Todo
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: TodoViewModel
    lateinit var todoRV: RecyclerView
    lateinit var addFloatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoRV = findViewById(R.id.todoRV)
        addFloatingActionButton = findViewById(R.id.idFAB)

        viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        todoRV.layoutManager = LinearLayoutManager(this)

        val todoRVAdapter = TodoAdapter(this, viewModel)
        todoRV.adapter = todoRVAdapter


        viewModel.allTodos.observe(this) { list ->
            list?.let {
                todoRVAdapter.updateList(it)
            }
        }

        addFloatingActionButton.setOnClickListener {
            addElementDialog()
        }

    }

    private fun addElementDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.add_edit_todo_layout)

        val titleEditText = dialog.findViewById<EditText>(R.id.editTextTitle)
        val saveButton = dialog.findViewById<Button>(R.id.btnSave)
        val cancelButton = dialog.findViewById<Button>(R.id.btnCancel)

        saveButton.setOnClickListener {
            val title = titleEditText.text.toString()
            if (title.isNotEmpty()) {
                val newTodo = Todo(title, System.currentTimeMillis().toString(), false)
                viewModel.addTodo(newTodo)

            }

            dialog.dismiss()
        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}