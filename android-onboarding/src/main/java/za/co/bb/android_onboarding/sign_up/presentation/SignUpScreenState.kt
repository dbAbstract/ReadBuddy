package za.co.bb.android_onboarding.sign_up.presentation

internal data class SignUpScreenState(
    val isLoading: Boolean,
    val username: String,
    val authHeaderApiKey: String,
    val authHeaderApiHost: String
)
