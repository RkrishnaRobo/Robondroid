package com.core.domain.onboarding.repository

import com.core.domain.onboarding.model.Joke

interface OnboardingRepository {
    suspend fun getRandomJokes(): Result<Joke>
    suspend fun firebaseSignUpWithEmailAndPassword(
        email: String,
        password: String,
    ): Result<Boolean>

    suspend fun firebaseLoginWithEmailAndPassword(
        email: String,
        password: String
    ): Result<Boolean>
}