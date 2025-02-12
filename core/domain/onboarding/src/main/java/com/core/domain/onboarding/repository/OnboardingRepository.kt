package com.core.domain.onboarding.repository

import com.core.domain.onboarding.model.Joke

interface OnboardingRepository {
    suspend fun getRandomJokes(): Result<Joke>
}