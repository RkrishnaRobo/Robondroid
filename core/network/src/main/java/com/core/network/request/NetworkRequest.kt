package com.core.network.request

data class NetworkRequest(
    val url: String,
    val method: HttpMethod,
    val headers: Map<String, String> = emptyMap(),
    val body: Any? = null
) {

    enum class HttpMethod {
        GET,
        DELETE,
        PATCH,
        POST,
        PUT
    }
}

