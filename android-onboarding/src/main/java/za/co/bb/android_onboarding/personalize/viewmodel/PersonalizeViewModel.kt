package za.co.bb.android_onboarding.personalize.viewmodel

import com.arcanium.books_domain.model.Genre
import com.arcanium.readbuddy.viewmodel.BaseViewModel
import za.co.bb.android_onboarding.personalize.presentation.PersonalizeScreenAction
import za.co.bb.android_onboarding.personalize.presentation.PersonalizeScreenEventHandler
import za.co.bb.android_onboarding.personalize.presentation.PersonalizeScreenState

internal class PersonalizeViewModel : BaseViewModel<PersonalizeScreenState, PersonalizeScreenAction>(
    state = PersonalizeScreenState()
) {
    private val minimumGenreSelections = 3

    val eventHandler = object : PersonalizeScreenEventHandler {
        override fun onGenreSelected(genre: Genre) {
            updateState {
                if (selectedGenres.contains(genre)) {
                    val currentSelection = selectedGenres.toMutableList()
                    currentSelection.remove(genre)
                    copy(selectedGenres = currentSelection)
                } else {
                    copy(selectedGenres = this.selectedGenres + genre)
                }
            }

            updateState {
                copy(canGoNext = selectedGenres.size >= minimumGenreSelections)
            }
        }

        override fun onNextClicked() {
            emitAction(PersonalizeScreenAction.NavigateToHome)
        }
    }
}