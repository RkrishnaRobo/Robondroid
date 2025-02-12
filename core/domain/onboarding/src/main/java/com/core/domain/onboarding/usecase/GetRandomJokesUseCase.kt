package com.core.domain.onboarding.usecase

import com.core.domain.onboarding.model.Joke
import com.core.domain.onboarding.repository.OnboardingRepository
import com.core.domain.usecase.UseCase
import javax.inject.Inject

class GetRandomJokesUseCase @Inject constructor(
    private val onboardingRepository: OnboardingRepository
) : UseCase.Suspending<Result<Joke>> {
    override suspend fun invoke(): Result<Joke> {
        return onboardingRepository.getRandomJokes()
    }
}
