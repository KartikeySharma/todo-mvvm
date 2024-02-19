package com.example.todo.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: Todo)

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)

    // CASE WHEN todoChecked = 1 THEN todoTimeStamp END DESC is a conditional statement that orders
    // by todoTimeStamp in descending order only if todoChecked is equal to 1 (true). This ensures
    // that if the item is checked, it will be ordered by timestamp in descending order.
    @Query("SELECT * FROM todoTable ORDER BY checked ASC, CASE WHEN checked = 1 THEN timestamp " +
            "END DESC, timestamp DESC")
    fun getAllTodo(): LiveData<List<Todo>>

}