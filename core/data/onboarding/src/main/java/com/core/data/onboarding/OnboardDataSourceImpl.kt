package com.core.data.onboarding

import com.core.data.onboarding.api.OnboardApi
import javax.inject.Inject

class OnboardDataSourceImpl @Inject constructor(
    private val onboardApi: OnboardApi
) : OnboardDataSource {
    override suspend fun getRandomJokes() = onboardApi.getRandomJokes()
}