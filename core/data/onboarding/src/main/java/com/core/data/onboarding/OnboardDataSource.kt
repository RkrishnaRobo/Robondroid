package com.core.data.onboarding

import com.core.data.onboarding.model.JokeNet
import com.google.firebase.auth.AuthResult

interface OnboardDataSource {
    suspend fun getRandomJokes(): Result<JokeNet>
    suspend fun firebaseSignUpWithEmailAndPassword(
        email: String,
        password: String,
    ): AuthResult

    suspend fun firebaseLoginWithEmailAndPassword(
        email: String,
        password: String,
    ): AuthResult
}
