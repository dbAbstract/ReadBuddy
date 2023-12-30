package za.co.bb.android_onboarding.navigation

import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.arcanium.readbuddy.navigation.NavAction
import com.arcanium.readbuddy.navigation.Screen
import com.arcanium.readbuddy.viewmodel.observeAction
import kotlinx.coroutines.launch
import za.co.bb.android_onboarding.sign_up.presentation.SignUpScreenAction
import za.co.bb.android_onboarding.sign_up.view.SignUpScreen
import za.co.bb.android_onboarding.sign_up.viewmodel.signUpViewModel

fun NavGraphBuilder.onboardingNavGraph(navigate: (NavAction) -> Unit) {
    navigation(
        startDestination = Screen.OnboardingGraph.SignUp.route,
        route = Screen.OnboardingGraph.route
    ) {
        composable(route = Screen.OnboardingGraph.SignUp.route) {
            val signUpViewModel = signUpViewModel()
            val uiState by signUpViewModel.uiState.collectAsStateWithLifecycle()
            val snackbarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()

            SignUpScreen(
                uiState = uiState,
                eventHandler = signUpViewModel.eventHandler
            )

            SnackbarHost(hostState = snackbarHostState)

            signUpViewModel.observeAction { action ->
                when (action) {
                    SignUpScreenAction.NavigateToCustomize -> navigate(NavAction.NavigateToPersonalize)

                    is SignUpScreenAction.ShowMessage -> scope.launch {
                        snackbarHostState.showSnackbar("Hello")
                    }
                }
            }
        }
    }
}