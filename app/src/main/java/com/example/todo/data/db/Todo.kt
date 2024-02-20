package com.example.todo.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todoTable")
class Todo(
    @ColumnInfo(name = "title") var todoTitle: String,
    @ColumnInfo(name = "timestamp") var todoTimeStamp: String,
    @ColumnInfo(name = "checked") var todoChecked: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}