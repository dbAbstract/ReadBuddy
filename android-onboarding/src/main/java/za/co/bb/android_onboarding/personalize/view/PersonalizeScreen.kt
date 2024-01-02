package za.co.bb.android_onboarding.personalize.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arcanium.readbuddy.ui.components.AppText

@Composable
fun PersonalizeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .safeContentPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppText(
            text = "Personalize your genres",
            textStyle = MaterialTheme.typography.titleSmall,
            maxLines = 3
        )
    }
}