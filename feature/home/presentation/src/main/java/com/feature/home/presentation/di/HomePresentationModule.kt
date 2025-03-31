package com.feature.home.presentation.di

import com.core.common.network.AppDispatchers
import com.core.common.network.Dispatcher
import com.feature.home.presentation.state.HomeScreenReducer
import com.feature.home.presentation.state.HomeScreenReducerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object HomePresentationModule {

    @Provides
    fun providesOnboardReducer(
        @Dispatcher(AppDispatchers.Default) defaultDispatcher: CoroutineDispatcher,
    ): HomeScreenReducer {
        return HomeScreenReducerImpl(defaultDispatcher)
    }
}
