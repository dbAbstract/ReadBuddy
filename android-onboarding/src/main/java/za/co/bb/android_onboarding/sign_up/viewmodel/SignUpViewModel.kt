package za.co.bb.android_onboarding.sign_up.viewmodel

import com.arcanium.readbuddy.viewmodel.BaseViewModel
import za.co.bb.android_onboarding.sign_up.presentation.SignUpScreenAction
import za.co.bb.android_onboarding.sign_up.presentation.SignUpScreenEventHandler
import za.co.bb.android_onboarding.sign_up.presentation.SignUpScreenState

internal class SignUpViewModel : BaseViewModel<SignUpScreenState, SignUpScreenAction>(
    state = SignUpScreenState(
        isLoading = false,
        username = "",
        authHeaderApiKey = "",
        authHeaderApiHost = ""
    )
) {
    val eventHandler = object : SignUpScreenEventHandler {
        override fun onUsernameChange(username: String) {
            updateState {
                copy(username = username)
            }
        }

        override fun onApiKeyChanged(value: String) {
            updateState {
                copy(authHeaderApiKey = value)
            }
        }

        override fun onApiHostChanged(value: String) {
            updateState {
                copy(authHeaderApiHost = value)
            }
        }

        override fun onNextClicked() {
            if (isInputValid()) {
                emitAction(SignUpScreenAction.NavigateToCustomize)
            } else {
                emitAction(SignUpScreenAction.ShowMessage("Invalid input"))
            }
        }
    }

    private fun isInputValid(): Boolean {
        return currentUiState.username.isNotEmpty() &&
                currentUiState.authHeaderApiKey.isNotEmpty() &&
                currentUiState.authHeaderApiHost.isNotEmpty()
    }
}