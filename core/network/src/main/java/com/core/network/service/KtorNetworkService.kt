package com.core.network.service

import com.core.network.request.NetworkRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

class KtorNetworkService(private val client: HttpClient) : NetworkService {

    @OptIn(InternalSerializationApi::class)
    override suspend fun <T : Any> makeRequest(
        request: NetworkRequest,
        responseClass: KClass<T>
    ): Result<T> {
        return try {
            val response: HttpResponse = client.request(request.url) {
                method = HttpMethod.parse(request.method.toString())
                headers {
                    request.headers.forEach { (key, value) ->
                        append(key, value)
                    }
                }
                if (request.method == NetworkRequest.HttpMethod.POST && request.body != null) {
                    setBody(request.body)
                }
            }

            val responseBody = response.bodyAsText()
            val parsedResponse = Json.decodeFromString(responseClass.serializer(), responseBody)
            Result.success(parsedResponse)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }
}
