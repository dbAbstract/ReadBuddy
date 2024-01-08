package za.co.bb.android_onboarding.personalize.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

@Suppress("UNCHECKED_CAST")
private class PersonalizeViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonalizeViewModel::class.java)) {
            return PersonalizeViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

@Composable
internal fun personalizeViewModel(): PersonalizeViewModel {
    return viewModel(factory = PersonalizeViewModelFactory())
}