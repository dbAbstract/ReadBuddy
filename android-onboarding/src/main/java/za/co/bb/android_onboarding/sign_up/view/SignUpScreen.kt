package za.co.bb.android_onboarding.sign_up.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arcanium.readbuddy.ui.components.AppButton
import com.arcanium.readbuddy.ui.components.AppText
import com.arcanium.readbuddy.ui.components.AppTextField
import za.co.bb.android_onboarding.sign_up.presentation.SignUpScreenEventHandler
import za.co.bb.android_onboarding.sign_up.presentation.SignUpScreenState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun SignUpScreen(
    uiState: SignUpScreenState,
    eventHandler: SignUpScreenEventHandler
) {
    val keyboardController = LocalSoftwareKeyboardController.current

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
                .clickable(
                    indication = null,
                    onClick = {
                        keyboardController?.hide()
                    },
                    interactionSource = MutableInteractionSource()
                )
        ) {
            AppText(
                text = "Welcome",
                textStyle = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(28.dp))

            AppTextField(
                value = uiState.username,
                onValueChanged = eventHandler::onUsernameChange,
                label = {
                    AppText(
                        text = "Username",
                        textStyle = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                modifier = Modifier.fillMaxWidth(COMPONENT_WIDTH_RATIO)
            )

            Spacer(modifier = Modifier.height(16.dp))

            AppTextField(
                value = uiState.authHeaderApiKey,
                onValueChanged = eventHandler::onApiKeyChanged,
                label = {
                    AppText(
                        text = "Api Key",
                        textStyle = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                modifier = Modifier.fillMaxWidth(COMPONENT_WIDTH_RATIO)
            )

            Spacer(modifier = Modifier.height(16.dp))

            AppTextField(
                value = uiState.authHeaderApiHost,
                onValueChanged = eventHandler::onApiHostChanged,
                label = {
                    AppText(
                        text = "Api Host",
                        textStyle = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(COMPONENT_WIDTH_RATIO)
                    .imePadding()
            )

            Spacer(modifier = Modifier.height(28.dp))

            AppButton(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth(COMPONENT_WIDTH_RATIO)
                    .imePadding(),
                onClick = eventHandler::onNextClicked,
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)
            ) {
                AppText(
                    text = "Next",
                    textStyle = TextStyle(fontSize = 16.sp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        if (uiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

}

private const val COMPONENT_WIDTH_RATIO = 0.7f

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
    override fun onNextClicked() = Unit
}