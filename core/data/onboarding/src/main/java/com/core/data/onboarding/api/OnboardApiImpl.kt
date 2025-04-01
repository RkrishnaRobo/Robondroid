package com.core.data.onboarding.api

import com.core.data.onboarding.model.JokeNet
import com.core.network.request.NetworkRequest
import com.core.network.service.NetworkService
import javax.inject.Inject

class OnboardApiImpl @Inject constructor(
    private val ktorClient: NetworkService
) : OnboardApi {

    override suspend fun getRandomJokes(): Result<JokeNet> {
        val request = NetworkRequest(url = "/random_joke", method = NetworkRequest.HttpMethod.GET)
        val result = ktorClient.makeRequest(request, JokeNet::class)
        return result
    }
}
