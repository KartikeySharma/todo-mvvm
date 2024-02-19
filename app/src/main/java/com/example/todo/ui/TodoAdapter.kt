package com.example.todo.ui

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.data.db.Todo

class TodoAdapter(
    private val context: Context,
    private val todoViewModel: TodoViewModel
) : RecyclerView.Adapter<TodoAdapter.ViewHolder>(){

    private val allTodos = ArrayList<Todo>()
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val todoTitle = itemView.findViewById<TextView>(R.id.idTitle)
        val todoChecked = itemView.findViewById<CheckBox>(R.id.idCheckBox)
        val todoDelete = itemView.findViewById<ImageView>(R.id.idDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(
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
        holder.apply {
            todoTitle.text = todo.todoTitle
            todoChecked.setOnCheckedChangeListener(null)
            todoChecked.isChecked = todo.todoChecked
        }
        holder.todoChecked.setOnCheckedChangeListener { _, isChecked ->
            val updatedTodo = Todo(todo.todoTitle, System.currentTimeMillis().toString() , todoChecked = isChecked)
            updatedTodo.id = todo.id
            todoViewModel.updateTodo(updatedTodo)
        }
        holder.todoDelete.setOnClickListener {
            showDialogToConfirmDelete(todo)
        }
    }

    private fun showDialogToConfirmDelete(todo: Todo) {
        val dialog = Dialog(context)

        dialog.setContentView(R.layout.confirm_delete_layout)

        val btnYes = dialog.findViewById<Button>(R.id.btnYes)
        val btnNo = dialog.findViewById<Button>(R.id.btnNo)

        btnYes.setOnClickListener {
            todoViewModel.deleteTodo(todo)
            dialog.dismiss()
        }

        btnNo.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun updateList(newList: List<Todo>) {
        allTodos.clear()
        allTodos.addAll(newList)
        notifyDataSetChanged()
    }
}