package za.co.bb.android_onboarding.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import com.arcanium.readbuddy.navigation.Screen
import com.arcanium.readbuddy.navigation.composable
import za.co.bb.android_onboarding.sign_up.view.SignUpScreen
import za.co.bb.android_onboarding.sign_up.viewmodel.signUpViewModel

fun NavGraphBuilder.onboardingNavGraph() {
    composable(screen = Screen.SignUp) {
        val signUpViewModel = signUpViewModel()
        val uiState by signUpViewModel.uiState.collectAsStateWithLifecycle()

        SignUpScreen(
            uiState = uiState,
            eventHandler = signUpViewModel.eventHandler
        )
    }
}