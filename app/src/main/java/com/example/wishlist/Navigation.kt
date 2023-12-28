package com.example.wishlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wishlist.ui.theme.noteviewmodel

@Composable
fun nav(noteviewmodel: noteviewmodel,navController: NavHostController = rememberNavController() ){
    NavHost(navController =navController , startDestination =  "home_screen"){
        composable("home_screen"){ homeScreen(navController = navController)}
        composable("user_input"){ editScreen(
            id = 0 ,
            navController = navController,
            noteviewmodel = noteviewmodel
        )}
    }



}


