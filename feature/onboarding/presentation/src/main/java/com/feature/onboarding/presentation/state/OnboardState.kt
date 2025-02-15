package com.feature.onboarding.presentation.state

import com.core.common.state.State

sealed class OnboardState : State {
    data object Loading : OnboardState()
    data class Content(val text: String) : OnboardState()
    data object Error : OnboardState()
    data object None : OnboardState()
}