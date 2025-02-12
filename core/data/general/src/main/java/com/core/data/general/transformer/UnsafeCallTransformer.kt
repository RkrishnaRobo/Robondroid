package com.core.data.general.transformer

suspend fun <T : Any> safeApiCall(
    call: suspend () -> T,
    errorHandler: suspend (e: Exception) -> Exception
): Result<T> {
    return try {
        Result.success(call())
    } catch (exception: Exception) {
        Result.failure(exception)
    }
}
