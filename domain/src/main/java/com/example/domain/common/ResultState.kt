package com.example.domain.common

sealed interface ResultState<out T> {
    data class Success<T>(val data: T) : ResultState<T>
    data class Error(val exception: Throwable) : ResultState<Nothing>
    //object Loading : Result<Nothing>
}