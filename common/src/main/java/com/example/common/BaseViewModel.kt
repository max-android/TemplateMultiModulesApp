package com.example.common

import androidx.lifecycle.ViewModel
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

    suspend fun sendSideEffect(sideEffect: BaseSideEffect?) {
        sideEffectInternal.emit(sideEffect)
    }

    abstract fun obtainEvent(event: BaseEvent?)

}