package com.example.wishlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun titlebar(title:String,
             onBackNavClicked: ()->Unit={}){
    val navigationButton : (@Composable () -> Unit) = {
        if(!title.contains("Notepad")){
            IconButton(onClick = { onBackNavClicked() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        }else{
            null
        }

    }
     TopAppBar(title = { Text(text = title,color = colorResource(id = R.color.black), modifier = Modifier.heightIn(3.dp,24.dp)) },
        elevation = 3.dp,
         backgroundColor = colorResource(id = R.color.titlebarrcolor),
         navigationIcon = {navigationButton()})


}