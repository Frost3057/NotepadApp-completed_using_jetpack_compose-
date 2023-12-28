package com.example.wishlist.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlist.Note
import com.example.wishlist.Noterespositery
import com.example.wishlist.notelist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class noteviewmodel(val noterepositery:Noterespositery) : ViewModel(){

     var changeTitle by mutableStateOf("")
     var changeDescription by mutableStateOf("")

     fun ChangeT(newString:String){
          changeTitle = newString
     }
     fun ChangeD(newString: String){
          changeDescription = newString
     }

     lateinit var getallnotes: Flow<List<Note>>

     init{
          viewModelScope.launch {
               getallnotes = noterepositery.getAllNotes()
          }
     }
     fun addNote(note: Note){

          viewModelScope.launch {
               noterepositery.AddNote(note)
          }
     }
     fun delNote(note: Note){

          viewModelScope.launch {
               noterepositery.delNote(note)
          }
     }
     fun updateNote(note: Note){

          viewModelScope.launch {
               noterepositery.updateNote(note)
          }
     }
     fun getAwish(id:Long){
          viewModelScope.launch {
               noterepositery.getaNote(id)
          }
     }

}