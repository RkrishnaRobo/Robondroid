package com.feature.home.presentation.di

import com.feature.home.presentation.state.register.RegisterReducer
import com.feature.home.presentation.state.register.RegisterReducerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RegisterPresentationModule {

    @Provides
    fun provideRegistrationReducer(): RegisterReducer {
        return RegisterReducerImpl()
    }
}
