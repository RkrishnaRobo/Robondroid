package com.core.data.onboarding.di

import com.core.data.onboarding.OnboardDataSource
import com.core.data.onboarding.OnboardDataSourceImpl
import com.core.data.onboarding.api.OnboardApi
import com.core.data.onboarding.api.OnboardApiImpl
import com.core.data.onboarding.repository.OnboardingRepositoryImpl
import com.core.domain.onboarding.repository.OnboardingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class OnboardDataModule {

    @Binds
    abstract fun bindOnBoardApi(onboardApiImpl: OnboardApiImpl): OnboardApi

    @Binds
    abstract fun bindOnboardDatasource(onboardDataSourceImpl: OnboardDataSourceImpl): OnboardDataSource

    @Binds
    abstract fun bindOnBoardingRepository(onboardingRepository: OnboardingRepositoryImpl): OnboardingRepository
}
