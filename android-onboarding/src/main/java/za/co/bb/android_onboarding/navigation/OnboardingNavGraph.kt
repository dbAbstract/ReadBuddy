package za.co.bb.android_onboarding.navigation

import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.arcanium.readbuddy.navigation.NavAction
import com.arcanium.readbuddy.navigation.OnboardingGraph
import com.arcanium.readbuddy.ui.util.showToast
import com.arcanium.readbuddy.viewmodel.observeAction
import za.co.bb.android_onboarding.personalize.view.PersonalizeScreen
import za.co.bb.android_onboarding.sign_up.presentation.SignUpScreenAction
import za.co.bb.android_onboarding.sign_up.view.SignUpScreen
import za.co.bb.android_onboarding.sign_up.viewmodel.signUpViewModel

fun NavGraphBuilder.onboardingNavGraph(navigate: (NavAction) -> Unit) {
    navigation(
        startDestination = OnboardingGraph.SignUp.route,
        route = OnboardingGraph.route
    ) {
        composable(route = OnboardingGraph.SignUp.route) {
            val signUpViewModel = signUpViewModel()
            val uiState by signUpViewModel.uiState.collectAsStateWithLifecycle()
            val context = LocalContext.current

            SignUpScreen(
                uiState = uiState,
                eventHandler = signUpViewModel.eventHandler
            )

            signUpViewModel.observeAction { action ->
                when (action) {
                    SignUpScreenAction.NavigateToCustomize -> navigate(NavAction.NavigateToPersonalize)

                    is SignUpScreenAction.ShowMessage -> {
                        context.showToast(message = action.message)
                    }
                }
            }
        }

        composable(route = OnboardingGraph.Personalize.route) {
            PersonalizeScreen()
        }
    }
}