package com.core.data.onboarding

import com.core.data.onboarding.model.JokeNet

interface OnboardDataSource {
    suspend fun getRandomJokes(): Result<JokeNet>
}