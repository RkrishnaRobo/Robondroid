package com.core.data.onboarding

import com.core.data.onboarding.api.OnboardApi
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class OnboardDataSourceImpl @Inject constructor(
    private val onboardApi: OnboardApi,
    private val auth: FirebaseAuth
) : OnboardDataSource {
    override suspend fun getRandomJokes() = onboardApi.getRandomJokes()

    override suspend fun firebaseSignUpWithEmailAndPassword(email: String, password: String): AuthResult {
        return auth.createUserWithEmailAndPassword(email, password).await()
    }

    override suspend fun firebaseLoginWithEmailAndPassword(email: String, password: String): AuthResult {
        return auth.signInWithEmailAndPassword(email, password).await()
    }
}
