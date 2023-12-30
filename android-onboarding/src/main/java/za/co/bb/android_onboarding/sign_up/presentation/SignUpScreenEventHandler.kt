package za.co.bb.android_onboarding.sign_up.presentation

import androidx.compose.runtime.Stable

@Stable
internal interface SignUpScreenEventHandler {
    fun onUsernameChange(username: String)

    fun onApiKeyChanged(value: String)

    fun onApiHostChanged(value: String)

    fun onNextClicked()
}