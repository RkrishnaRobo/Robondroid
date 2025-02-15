package com.feature.onboarding.presentation.di

import com.core.common.network.AppDispatchers
import com.core.common.network.Dispatcher
import com.feature.onboarding.presentation.state.OnboardReducer
import com.feature.onboarding.presentation.state.OnboardReducerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnboardPresentationModule {

    @Provides
    @Singleton
    fun providesOnboardReducer(
        @Dispatcher(AppDispatchers.Default) defaultDispatcher: CoroutineDispatcher,
    ): OnboardReducer {
        return OnboardReducerImpl(defaultDispatcher)
    }
}
