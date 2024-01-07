package com.arcanium.readbuddy.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.arcanium.readbuddy.navigation.OnboardingGraph
import com.arcanium.readbuddy.navigation.Screen
import com.arcanium.readbuddy.navigation.navigate
import za.co.bb.android_onboarding.navigation.onboardingNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setThemedContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = OnboardingGraph.route,
                enterTransition = {
                    slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Left)
                }
            ) {
                onboardingNavGraph(navigate = navController::navigate)
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
