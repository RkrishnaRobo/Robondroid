package com.feature.register.presentation.di

import com.feature.register.presentation.state.register.RegisterReducer
import com.feature.register.presentation.state.register.RegisterReducerImpl
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
