package za.co.bb.android_onboarding.personalize.presentation

import com.arcanium.books_domain.model.Genre

internal data class PersonalizeScreenState(
    val genres: List<Genre> = Genre.entries.toList(),
    val selectedGenres: List<Genre> = emptyList(),
    val canGoNext: Boolean = false
)