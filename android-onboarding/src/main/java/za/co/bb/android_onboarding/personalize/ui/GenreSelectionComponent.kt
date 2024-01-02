package za.co.bb.android_onboarding.personalize.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arcanium.readbuddy.ui.components.AppText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun GenreSelectionComponent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    genreName: String
) {
    Card(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        onClick = onClick
    ) {
        Spacer(modifier = Modifier.weight(1f))
        AppText(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = genreName,
            textStyle = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
private fun GenreSelectionComponentPreview() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
    ) {
        GenreSelectionComponent(
            modifier = Modifier
                .width(100.dp)
                .height(40.dp)
                .align(Alignment.Center),
            onClick = {},
            genreName = "Fantasy"
        )
    }
}