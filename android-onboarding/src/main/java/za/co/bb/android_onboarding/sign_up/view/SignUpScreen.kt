package za.co.bb.android_onboarding.sign_up.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.alpha(if (uiState.isLoading) 0.3f else 1f)
        ) {
            AppTextField(
                value = uiState.username,
                onValueChanged = eventHandler::onUsernameChange,
                label = {
                    AppText(text = "Username")
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            AppTextField(
                value = uiState.authHeaderApiHost,
                onValueChanged = eventHandler::onApiKeyChanged,
                label = {
                    AppText(text = "Api Key")
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            AppTextField(
                value = uiState.authHeaderApiHost,
                onValueChanged = eventHandler::onApiKeyChanged,
                label = {
                    AppText(text = "Api Key")
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

@Preview
@Composable
private fun SignUpScreenPreview() {
    
}