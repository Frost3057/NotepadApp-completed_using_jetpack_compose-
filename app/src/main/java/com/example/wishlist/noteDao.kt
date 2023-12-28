package com.example.wishlist

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class noteDao {
    @Insert
    abstract  fun addNote(noteEntity: Note)

    @Delete
    abstract fun delNote(noteEntity:Note)

    @Update
    abstract fun updateNote(noteEntity: Note)

    @Query("Select * from `note-table`")
    abstract  fun showAll():Flow<List<Note>>
    @Query("Select id from `note-table`")
    abstract  fun showNote(id:Long):Flow<Note>
}