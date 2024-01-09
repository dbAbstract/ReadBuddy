package za.co.bb.android_onboarding.personalize.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arcanium.books_domain.model.Genre
import com.arcanium.readbuddy.ui.components.AppText

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GenreSelectionGrid(
    genres: List<Genre>,
    selectedGenres: List<Genre>,
    onClick: (genre: Genre) -> Unit,
    modifier: Modifier = Modifier
) {
    FlowRow(modifier = modifier) {
        genres.forEach { genre ->
            val isSelected by remember(selectedGenres) {
                derivedStateOf { selectedGenres.contains(genre) }
            }

            GenreSelectionComponent(
                modifier = Modifier
                    .widthIn(min = 80.dp)
                    .height(50.dp)
                    .padding(4.dp),
                onClick = {
                    onClick(genre)
                },
                genre = genre,
                isSelected = isSelected
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GenreSelectionComponent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    genre: Genre,
    isSelected: Boolean
) {
    Card(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary
        ),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.background
            }
        )
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .align(Alignment.CenterHorizontally)
        ) {
            AppText(
                text = genre.value,
                textStyle = MaterialTheme.typography.bodySmall,
                color = if (isSelected)
                    MaterialTheme.colorScheme.onPrimaryContainer
                else
                    MaterialTheme.colorScheme.onBackground
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
            genre = Genre.Fantasy,
            isSelected = true
        )
    }
}