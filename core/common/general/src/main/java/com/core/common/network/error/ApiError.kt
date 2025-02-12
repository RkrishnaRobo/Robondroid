package com.core.common.network.error

sealed class ApiError {
    data class ServerError(
        val url: String,
        val status: Int,
        val message: String,
        val cause: Throwable
    ) : ApiError()

    data class ClientRequestError(
        val url: String,
        val status: Int,
        val message: String,
        val cause: Throwable
    ) : ApiError()

    data object NetworkError : ApiError()
    data object TimeoutError : ApiError()
    data object UnknownError : ApiError()
}
