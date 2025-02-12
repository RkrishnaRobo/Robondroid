package com.core.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientFactory(
    private val httpEngine: HttpClientEngine,
) {

    companion object {
        const val REQUEST_DEFAULT_TIMEOUT_MILLIS = 30_000L
        const val REQUEST_BASE_URL = "https://official-joke-api.appspot.com"
    }


    fun create(): HttpClient {
        return HttpClient(httpEngine) {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                url(REQUEST_BASE_URL)
            }

            install(HttpTimeout) {
                requestTimeoutMillis = REQUEST_DEFAULT_TIMEOUT_MILLIS
            }

            install(ResponseObserver) {
                onResponse { response ->
                    //Log.d("HTTP status:", "${response.status.value}")
                }
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        //Log.v("Logger Ktor =>", message)
                    }
                }
                level = LogLevel.ALL
            }
        }
    }

}