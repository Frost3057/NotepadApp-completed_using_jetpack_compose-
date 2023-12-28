package com.example.wishlist

sealed class routes(val route:String) {
    data object Homescreen : routes("home_screen")
    data object EditScreen : routes("user_input")
}

