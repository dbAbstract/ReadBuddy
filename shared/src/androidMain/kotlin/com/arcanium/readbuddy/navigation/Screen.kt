package com.arcanium.readbuddy.navigation

sealed class Screen(val route: String) {
    data object OnboardingGraph : Screen(route = "Onboarding") {
        data object SignUp : Screen(route = "Login")
    }
}