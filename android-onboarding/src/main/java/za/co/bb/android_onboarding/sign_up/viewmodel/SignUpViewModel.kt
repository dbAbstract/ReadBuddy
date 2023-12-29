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
            TODO("Not yet implemented")
        }

        override fun onApiKeyChanged(value: String) {
            TODO("Not yet implemented")
        }

        override fun onApiHostChanged(value: String) {
            TODO("Not yet implemented")
        }

    }
}