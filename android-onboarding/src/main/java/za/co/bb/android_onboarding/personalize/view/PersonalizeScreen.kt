package za.co.bb.android_onboarding.personalize.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arcanium.books_domain.model.Genre
import com.arcanium.readbuddy.ui.components.AppText
import za.co.bb.android_onboarding.personalize.ui.GenreSelectionGrid

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
            modifier = Modifier
                .padding(vertical = 8.dp),
            text = "Pick at least 3 Genres",
            textStyle = MaterialTheme.typography.titleSmall,
            maxLines = 3
        )
        
        GenreSelectionGrid(
            items = Genre.entries.map { it.value },
            onClick = {}
        )
    }
}