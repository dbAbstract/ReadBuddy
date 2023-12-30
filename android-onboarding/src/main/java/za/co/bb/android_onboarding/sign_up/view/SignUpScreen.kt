package za.co.bb.android_onboarding.sign_up.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arcanium.readbuddy.ui.components.AppText
import com.arcanium.readbuddy.ui.components.AppTextField
import za.co.bb.android_onboarding.sign_up.presentation.SignUpScreenEventHandler
import za.co.bb.android_onboarding.sign_up.presentation.SignUpScreenState

@Composable
internal fun SignUpScreen(
    uiState: SignUpScreenState,
    eventHandler: SignUpScreenEventHandler
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .alpha(if (uiState.isLoading) 0.3f else 1f)
        ) {
            AppTextField(
                value = uiState.username,
                onValueChanged = eventHandler::onUsernameChange,
                label = {
                    AppText(
                        text = "Username",
                        textStyle = MaterialTheme.typography.labelMedium
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            AppTextField(
                value = uiState.authHeaderApiHost,
                onValueChanged = eventHandler::onApiKeyChanged,
                label = {
                    AppText(
                        text = "Api Key",
                        textStyle = MaterialTheme.typography.labelMedium
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            AppTextField(
                value = uiState.authHeaderApiHost,
                onValueChanged = eventHandler::onApiKeyChanged,
                label = {
                    AppText(
                        text = "Api Host",
                        textStyle = MaterialTheme.typography.labelMedium
                    )
                }
            )
        }

        if (uiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen(
        uiState = SignUpScreenState(
            isLoading = false,
            username = "Test",
            authHeaderApiKey = "Api Key",
            authHeaderApiHost = "Api Host"
        ),
        eventHandler = previewEventHandler
    )
}

private val previewEventHandler = object : SignUpScreenEventHandler {
    override fun onUsernameChange(username: String) = Unit
    override fun onApiKeyChanged(value: String) = Unit
    override fun onApiHostChanged(value: String) = Unit
}