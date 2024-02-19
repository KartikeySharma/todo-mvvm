package com.example.todo.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todoTable")
class Todo(
    @ColumnInfo(name = "title") val todoTitle: String,
    @ColumnInfo(name = "timestamp") val todoTimeStamp: String,
    @ColumnInfo(name = "checked") var todoChecked: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}