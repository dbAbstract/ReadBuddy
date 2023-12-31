package com.arcanium.readbuddy.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel<State, Action>(state: State) : ViewModel() {
    private val _action = Channel<Action>()
    val action = _action.receiveAsFlow()

    private val _uiState = MutableStateFlow(state)
    val uiState = _uiState.asStateFlow()

    protected val currentUiState: State
        get() = uiState.value

    protected fun emitAction(action: Action) {
        viewModelScope.launch {
            _action.send(element = action)
        }
    }

    protected fun updateState(block: State.() -> State) = _uiState.update(block)
}

@SuppressLint("ComposableNaming")
@Composable
fun <State, Action> BaseViewModel<State, Action>.observeAction(
    flowCollector: FlowCollector<Action>
) {
    LaunchedEffect(key1 = Unit) {
        withContext(Dispatchers.Main.immediate) {
            action.collect(flowCollector)
        }
    }
}