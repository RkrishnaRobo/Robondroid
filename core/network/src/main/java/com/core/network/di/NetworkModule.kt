package com.core.network.di

import com.core.network.ktor.HttpClientFactory
import com.core.network.service.KtorNetworkService
import com.core.network.service.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesKtorClient(): HttpClient {
        return HttpClientFactory(httpEngine = OkHttp.create {
            config {
                // add any okhttp configuration
            }
        }).create()

    }

    @Provides
    @Singleton
    fun providesNetworkService(client: HttpClient): NetworkService = KtorNetworkService(client)

}