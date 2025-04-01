package com.core.data.onboarding.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JokeNet(
    @SerialName("type")
    val type: String? = null,
    @SerialName("setup")
    val setup: String? = null,
    @SerialName("punchline")
    val punchline: String? = null,
    @SerialName("id")
    val id: Int? = 0
)
