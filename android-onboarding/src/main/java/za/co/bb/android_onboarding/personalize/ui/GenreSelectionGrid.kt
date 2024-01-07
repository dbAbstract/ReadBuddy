package za.co.bb.android_onboarding.personalize.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GenreSelectionGrid(
    items: List<String>,
    onClick: (genreName: String) -> Unit,
    modifier: Modifier = Modifier
) {
    FlowRow(modifier = modifier) {
        items.forEach { genreName ->
            GenreSelectionComponent(
                modifier = Modifier
                    .widthIn(min = 80.dp)
                    .height(50.dp)
                    .padding(4.dp),
                onClick = {
                    onClick(genreName)
                },
                genreName = genreName
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GenreSelectionComponent(
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
        Box(modifier = Modifier
            .padding(4.dp)
            .align(Alignment.CenterHorizontally)
        ) {
            AppText(
                text = genreName,
                textStyle = MaterialTheme.typography.bodySmall
            )
        }
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