package com.core.network.service

import com.core.network.request.NetworkRequest
import kotlin.reflect.KClass

interface NetworkService {
    suspend fun <T : Any> makeRequest(
        request: NetworkRequest,
        responseClass: KClass<T>
    ): Result<T>
}
