package za.co.bb.android_onboarding.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.arcanium.readbuddy.navigation.Screen
import za.co.bb.android_onboarding.sign_up.view.SignUpScreen
import za.co.bb.android_onboarding.sign_up.viewmodel.signUpViewModel

fun NavGraphBuilder.onboardingNavGraph() {
    navigation(
        startDestination = Screen.OnboardingGraph.SignUp.route,
        route = Screen.OnboardingGraph.route
    ) {
        composable(route = Screen.OnboardingGraph.SignUp.route) {
            val signUpViewModel = signUpViewModel()
            val uiState by signUpViewModel.uiState.collectAsStateWithLifecycle()

            SignUpScreen(
                uiState = uiState,
                eventHandler = signUpViewModel.eventHandler
            )
        }
    }
}