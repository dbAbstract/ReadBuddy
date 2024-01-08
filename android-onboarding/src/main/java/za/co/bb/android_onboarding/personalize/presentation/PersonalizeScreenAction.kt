package za.co.bb.android_onboarding.personalize.presentation

internal sealed interface PersonalizeScreenAction {
    data object NavigateToHome : PersonalizeScreenAction
}