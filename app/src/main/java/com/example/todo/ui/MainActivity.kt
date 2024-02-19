package com.example.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.data.db.Todo
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TodoViewModel
    private lateinit var todoRV: RecyclerView
    private lateinit var addFloatingActionButton: FloatingActionButton

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
            showAddTodoItemDialog()
        }

    }

    private fun showAddTodoItemDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.add_edit_todo_layout, null)
        builder.setView(view)

        // Adjust the width and height as needed
        val width = resources.getDimensionPixelSize(R.dimen.dialog_width)
        val height = resources.getDimensionPixelSize(R.dimen.dialog_height)

        val dialog = builder.create()
        dialog.window?.setLayout(width, height)

        val titleEditText = view.findViewById<EditText>(R.id.editTextTitle)
        val btnSave = view.findViewById<Button>(R.id.btnSave)
        val btnCancel = view.findViewById<Button>(R.id.btnCancel)

        btnSave.setOnClickListener {
            val title = titleEditText?.text.toString()
            if (title.isNotEmpty()) {
                val newTodo = Todo(title, System.currentTimeMillis().toString(), false)
                viewModel.addTodo(newTodo)
            }
            dialog.dismiss()
        }

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}