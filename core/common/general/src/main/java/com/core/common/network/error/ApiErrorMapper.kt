package com.core.common.network.error

import kotlinx.coroutines.TimeoutCancellationException
import java.io.IOException

class ApiErrorMapper {

    suspend fun map(exception: Throwable): ApiError {
        return when (exception) {
           /* is ServerResponseException -> ApiError.ServerError(
                url = exception.response.request.url.toString(),
                cause = exception,
                status = exception.response.status.value,
                message = exception.response.bodyAsText()
            )

            is ClientRequestException -> ApiError.ClientRequestError(
                url = exception.response.request.url.toString(),
                cause = exception,
                status = exception.response.status.value,
                message = exception.response.bodyAsText()
            )*/

            is TimeoutCancellationException -> ApiError.TimeoutError
            is IOException -> ApiError.NetworkError
            else -> ApiError.UnknownError
        }
    }
}
