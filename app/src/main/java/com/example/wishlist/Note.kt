package com.example.wishlist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("note-table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0L,
    @ColumnInfo("note-title")
    val title:String = "",
    @ColumnInfo("note-desc")
    val description: String = "")
object notelist{
    val notel = listOf<Note>()
}

object  Dummynote{
    val notelist = listOf(
        Note(1,"Confidential Stuff","Email id: amanbajpai5660@gmail.com")
        ,Note(2,"Maths","The syllabus of cat 2 is as follows")
    )
}
