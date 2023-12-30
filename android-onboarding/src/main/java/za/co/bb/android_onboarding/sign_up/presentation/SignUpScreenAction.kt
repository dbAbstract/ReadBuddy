package za.co.bb.android_onboarding.sign_up.presentation

sealed interface SignUpScreenAction {
    data class ShowMessage(val message: String) : SignUpScreenAction

    data object NavigateToCustomize : SignUpScreenAction
}