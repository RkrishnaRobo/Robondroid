package com.core.data.onboarding.repository

import com.core.common.network.AppDispatchers
import com.core.common.network.Dispatcher
import com.core.data.general.transformer.runCatchingWithContext
import com.core.data.onboarding.OnboardDataSource
import com.core.data.onboarding.mapper.JokeNetToJokeMapper
import com.core.domain.onboarding.model.Joke
import com.core.domain.onboarding.repository.OnboardingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OnboardingRepositoryImpl @Inject constructor(
    private val onboardDataSource: OnboardDataSource,
    private val jokeNetToJokeMapper: JokeNetToJokeMapper,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : OnboardingRepository {

    override suspend fun getRandomJokes(): Result<Joke> {
        return withContext(ioDispatcher) {
            return@withContext onboardDataSource.getRandomJokes()
                .map { jokeNetToJokeMapper.map(it) }
        }
    }

    override suspend fun firebaseSignUpWithEmailAndPassword(email: String, password: String): Result<Boolean> {
        return runCatchingWithContext(ioDispatcher) {
            val user = onboardDataSource.firebaseSignUpWithEmailAndPassword(email, password)
            user.user != null
        }
    }

    override suspend fun firebaseLoginWithEmailAndPassword(email: String, password: String): Result<Boolean> {
        return runCatchingWithContext(ioDispatcher) {
            val user = onboardDataSource.firebaseLoginWithEmailAndPassword(email, password)
            user.user != null
        }
    }
}