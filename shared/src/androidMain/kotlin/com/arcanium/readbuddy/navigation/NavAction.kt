package com.arcanium.readbuddy.navigation

sealed interface NavAction {
    data object Back : NavAction
    data object NavigateToPersonalize : NavAction
    data object NavigateToHome : NavAction
}