package com.core.domain.onboarding.model

data class Joke(
    val type: String,
    val setup: String,
    val punchline: String,
    val id: Int? = 0
)