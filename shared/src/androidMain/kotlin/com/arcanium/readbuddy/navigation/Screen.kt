package com.arcanium.readbuddy.navigation

sealed class Screen(val route: String) {
    data object SignUp : Screen(route = "Login")
}