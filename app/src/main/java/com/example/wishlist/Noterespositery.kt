package com.example.wishlist

import org.intellij.lang.annotations.Flow

class Noterespositery(private val noteDao: noteDao) {
    suspend fun AddNote(note: Note){
        noteDao.addNote(note)
    }
    suspend fun delNote(note: Note){
        noteDao.delNote(note)
    }
    suspend fun updateNote(note: Note){
        noteDao.updateNote(note)
    }
     fun getAllNotes() = noteDao.showAll()

    fun getaNote(id:Long) = noteDao.showNote(id)

}