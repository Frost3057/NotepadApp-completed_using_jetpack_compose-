package com.example.wishlist

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlist.ui.theme.noteviewmodel

@Composable
fun homeScreen(navController: NavController){
    val context = LocalContext.current
    Scaffold(topBar = { titlebar("Notepad") {
        Toast.makeText(context, "BUTTON CLICKED", Toast.LENGTH_LONG).show()
    }
    }, floatingActionButton = {FloatingActionButton(onClick = { Toast.makeText(context,"Plus button clicked",Toast.LENGTH_LONG).show()
                                                              navController.navigate(routes.EditScreen.route)},contentColor = Color.Black,
        containerColor = Color.Cyan, modifier = Modifier.padding(all = 20.dp)) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
    }}
        ) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(it)){

        items(Dummynote.notelist){
            note->
            NoteItem(note = note, navController = NavController(context) )
            
        }


    }
    }


}

@Composable
fun NoteItem(note: Note,onClick: ()->Unit={},navController: NavController){
    Card(modifier = Modifier
        .padding(start = 8.dp, end = 8.dp, top = 8.dp)
        .fillMaxWidth()
        .clickable { navController.navigate(routes.EditScreen.route) },
        elevation = CardDefaults.cardElevation(16.dp),
        colors = CardDefaults.cardColors(Color.White)
        ){
        Column {
            Text(text = note.title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start =10.dp, top = 10.dp))
           Spacer(modifier = Modifier.padding(5.dp))
            Text(text = note.description,modifier = Modifier.padding(start = 10.dp, bottom = 10.dp))
        }

    }
}