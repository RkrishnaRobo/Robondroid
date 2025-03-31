package com.feature.onboarding.presentation.di

import com.feature.onboarding.presentation.state.register.RegisterReducer
import com.feature.onboarding.presentation.state.register.RegisterReducerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object OnboardPresentationModule {

    @Provides
    fun provideRegistrationReducer(): RegisterReducer {
        return RegisterReducerImpl()
    }
}
