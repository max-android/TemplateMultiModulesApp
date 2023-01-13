package com.example.data.common

import com.example.common.*
import java.net.HttpURLConnection

@Throws(Exception::class)
fun throwException(responseCode: Int, message: String): Exception {
    return when (responseCode) {

        HttpURLConnection.HTTP_UNAUTHORIZED, HttpURLConnection.HTTP_FORBIDDEN
        -> AccessDeniedException()

        HttpURLConnection.HTTP_NOT_FOUND -> ServerProblemException(message)

        HttpURLConnection.HTTP_INTERNAL_ERROR, HttpURLConnection.HTTP_NOT_IMPLEMENTED,
        HttpURLConnection.HTTP_BAD_GATEWAY, HttpURLConnection.HTTP_UNAVAILABLE,
        HttpURLConnection.HTTP_GATEWAY_TIMEOUT, HttpURLConnection.HTTP_VERSION,
        -> ServiceUnavailable()

        HttpURLConnection.HTTP_ENTITY_TOO_LARGE -> RequestTooLargeException()

        HttpURLConnection.HTTP_BAD_METHOD, HttpURLConnection.HTTP_NOT_ACCEPTABLE
        -> UserRequestException()

        UNPROCESSABLE_CODE -> UnprocessableException()

        else -> {
            Exception(message)
        }
    }
}

private const val UNPROCESSABLE_CODE = 422