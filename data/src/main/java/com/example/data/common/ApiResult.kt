package com.example.data.common

sealed interface ApiResult<T: Any>

class ApiSuccess<T: Any>(val data: T) : ApiResult<T>
class ApiError<T: Any>(val code: Int, val message: String?) : ApiResult<T>
class ApiException<T: Any>(val throwable: Throwable) : ApiResult<T>