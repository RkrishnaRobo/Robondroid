package com.core.data.onboarding.api

import com.core.data.onboarding.model.JokeNet

interface OnboardApi {
    // added this access the network module
    suspend fun getRandomJokes(): Result<JokeNet>
}