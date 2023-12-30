package com.arcanium.readbuddy.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.arcanium.readbuddy.navigation.Screen
import za.co.bb.android_onboarding.navigation.onboardingNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemedContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Screen.OnboardingGraph.route
            ) {
                onboardingNavGraph()
            }
        }
    }
}

private fun ComponentActivity.setThemedContent(
    content: @Composable () -> Unit
) {
    setContent {
        MyApplicationTheme {
            content()
        }
    }
}
