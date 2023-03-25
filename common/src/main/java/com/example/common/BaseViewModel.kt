package com.example.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.*

abstract class BaseViewModel : ViewModel() {

    private val stateInternal = MutableStateFlow<BaseViewState?>(null)
    val state: StateFlow<BaseViewState?> = stateInternal.asStateFlow()

    private val sideEffectInternal = MutableSharedFlow<BaseSideEffect?>()
    val sideEffect: SharedFlow<BaseSideEffect?> = sideEffectInternal.asSharedFlow()

    interface BaseViewState
    interface BaseSideEffect
    interface BaseEvent

    suspend fun sendState(viewState: BaseViewState?) {
        stateInternal.emit(viewState)
    }

    suspend fun sendSideEffect(event: BaseSideEffect?) {
        sideEffectInternal.emit(event)
    }

    abstract fun obtainEvent(event: BaseEvent?)

//    @Composable
//    fun collect(): State<BaseViewState?> {
//        return state.collectAsStateWithLifecycle()
//    }
}