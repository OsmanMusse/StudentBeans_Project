package com.example.sbtechincaltest.presentation.util

sealed class Screen(val route: String) {
    object LoginScreen: Screen("login_screen")
    object PhotoScreen: Screen("photo_screen")
}
