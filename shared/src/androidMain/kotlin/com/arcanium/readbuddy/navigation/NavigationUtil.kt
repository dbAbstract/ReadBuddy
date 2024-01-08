package com.arcanium.readbuddy.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.composable(
    screen: Screen,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) = composable(route = screen.route, content = content)

fun NavHostController.navigate(navAction: NavAction) {
    when (navAction) {
        NavAction.Back -> popBackStack()

        NavAction.NavigateToPersonalize -> navigate(route = OnboardingGraph.Personalize.route)

        NavAction.NavigateToHome -> navigate(route = "Home") {
            popUpTo(OnboardingGraph.Personalize.route) {
                inclusive = true
            }
        }
    }
}