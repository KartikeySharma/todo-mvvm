package com.example.todo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.data.db.Todo
import com.example.todo.ui.TodoViewModel

class TodoAdapter(
    val context: Context,
    private val todoViewModel: TodoViewModel
) : RecyclerView.Adapter<TodoAdapter.ViewHolder>(){

    private val allTodos = ArrayList<Todo>()
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val todoTitle = itemView.findViewById<TextView>(R.id.idTitle)
        val todoChecked = itemView.findViewById<CheckBox>(R.id.idCheckBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.todo_rv_item,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return allTodos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = allTodos[position]
        holder.todoTitle.text = todo.todoTitle
        holder.todoChecked.isChecked = todo.todoChecked
        holder.todoChecked.setOnCheckedChangeListener { _, isChecked ->
            val updatedtodo = Todo(todo.todoTitle, todo.todoTimeStamp, todoChecked = isChecked)
            updatedtodo.id = todo.id
            todoViewModel.updateTodo(updatedtodo)
        }
    }

    fun updateList(newList: List<Todo>) {
        allTodos.clear()
        allTodos.addAll(newList)
        notifyDataSetChanged()
    }
}