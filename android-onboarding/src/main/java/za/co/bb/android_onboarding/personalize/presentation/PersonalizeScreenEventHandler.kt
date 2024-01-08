package za.co.bb.android_onboarding.personalize.presentation

import androidx.compose.runtime.Stable
import com.arcanium.books_domain.model.Genre

@Stable
internal interface PersonalizeScreenEventHandler {
    fun onGenreSelected(genre: Genre)
    fun onNextClicked()
}