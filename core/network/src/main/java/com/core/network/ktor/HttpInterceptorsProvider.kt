package com.core.network.ktor

import io.ktor.client.HttpClientConfig

class HttpInterceptorsProvider {

    fun install(httpClientConfig: HttpClientConfig<*>) {
        // The order in which the interceptors are installed matters.
        // Requests will be intercepted according to the sequence defined below.
    }
}