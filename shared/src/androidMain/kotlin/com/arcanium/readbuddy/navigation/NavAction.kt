package com.arcanium.readbuddy.navigation

sealed interface NavAction {
    data object Back : NavAction
}