package com.arcanium.readbuddy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

open class BaseViewModel<State, Action>(state: State) : ViewModel() {
    private val _action = Channel<Action>()
    val action = _action.receiveAsFlow()

    private val _uiState = MutableStateFlow(state)
    val uiState = _uiState.asStateFlow()

    protected fun emitAction(action: Action) {
        viewModelScope.launch {
            _action.send(element = action)
        }
    }
}