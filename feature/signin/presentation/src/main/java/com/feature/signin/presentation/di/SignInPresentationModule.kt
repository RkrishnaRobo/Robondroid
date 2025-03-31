package com.feature.signin.presentation.di

import com.feature.signin.presentation.state.SignInReducer
import com.feature.signin.presentation.state.SignInReducerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SignInPresentationModule {

    @Provides
    fun provideRegistrationReducer(): SignInReducer {
        return SignInReducerImpl()
    }
}
