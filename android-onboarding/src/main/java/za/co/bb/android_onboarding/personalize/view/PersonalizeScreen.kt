package za.co.bb.android_onboarding.personalize.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arcanium.readbuddy.ui.components.AppButton
import com.arcanium.readbuddy.ui.components.AppText
import za.co.bb.android_onboarding.personalize.presentation.PersonalizeScreenEventHandler
import za.co.bb.android_onboarding.personalize.presentation.PersonalizeScreenState
import za.co.bb.android_onboarding.personalize.ui.GenreSelectionGrid

@Composable
internal fun PersonalizeScreen(
    uiState: PersonalizeScreenState,
    eventHandler: PersonalizeScreenEventHandler
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .safeContentPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppText(
            modifier = Modifier
                .padding(top = 36.dp, bottom = 16.dp),
            text = "Pick at least 3 Genres",
            textStyle = MaterialTheme.typography.titleSmall,
            maxLines = 3
        )
        
        GenreSelectionGrid(
            modifier = Modifier.padding(bottom = 100.dp),
            genres = uiState.genres,
            onClick = eventHandler::onGenreSelected,
            selectedGenres = uiState.selectedGenres
        )

        AppButton(
            modifier = Modifier.width(180.dp),
            onClick = eventHandler::onNextClicked,
            enabled = uiState.canGoNext
        ) {
            AppText(text = "Next", color = MaterialTheme.colorScheme.onPrimaryContainer)
        }
    }
}