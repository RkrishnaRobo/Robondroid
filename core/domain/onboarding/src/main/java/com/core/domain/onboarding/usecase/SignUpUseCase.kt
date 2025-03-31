package com.core.domain.onboarding.usecase

import com.core.domain.onboarding.model.SignUpParams
import com.core.domain.onboarding.repository.OnboardingRepository
import com.core.domain.usecase.UseCase
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val onboardingRepository: OnboardingRepository
) : UseCase.SuspendingParameterized<SignUpParams, Result<Boolean>> {

    override suspend fun invoke(param: SignUpParams): Result<Boolean> {
        return onboardingRepository.firebaseSignUpWithEmailAndPassword(param.userName, param.password)
    }
}

