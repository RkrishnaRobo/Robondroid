package com.feature.onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.feature.onboarding.presentation.state.OnboardState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

abstract class OnboardViewModel : ViewModel() {
    abstract val state: Flow<OnboardState>
}