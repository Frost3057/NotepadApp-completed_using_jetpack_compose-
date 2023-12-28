package com.example.wishlist

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField

import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlist.ui.theme.noteviewmodel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun editScreen(
               id:Long,navController: NavController,noteviewmodel: noteviewmodel){
    val context = LocalContext.current
    Scaffold(topBar = {
        titlebar(title =
    if(id != 0L) stringResource(id = R.string.edit_note) else stringResource(R.string.add_note)
        ) {
            navController.navigateUp()
        }
    }){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
        ,  horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.padding(8.dp))
            textfield(label = "Title", nonexchangeable = {
                                                         noteviewmodel.ChangeT(it)

            } , value = noteviewmodel.changeTitle)
            Spacer(modifier = Modifier.padding(8.dp))
            textfield(label = "Description", nonexchangeable = {noteviewmodel.ChangeD(it)  }, value =noteviewmodel.changeDescription )
            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick = { if (noteviewmodel.changeDescription.isNotEmpty() && noteviewmodel.changeTitle.isNotEmpty()){

            }else{
                Toast.makeText(context,"Enter every field value",Toast.LENGTH_LONG).show()
            }
                navController.navigateUp()
            }) {
                if(id != 0L) Text(text = stringResource(id = R.string.edit_note)) else Text(text = stringResource(R.string.add_note))

            }
            
        }

    }

}

@Composable
fun textfield(
    label: String,
    nonexchangeable: (String)->Unit,
    value: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = nonexchangeable,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        label = {Text(text = label)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black
            , focusedBorderColor = Color.Black
            , unfocusedBorderColor = Color.Black
            , cursorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black
        )
        )

}