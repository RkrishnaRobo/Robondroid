package com.feature.onboarding.presentation.state

import com.core.common.state.Action

sealed class OnboardAction : Action {
    data object Load : OnboardAction()
    data class SetContent(val text: String) : OnboardAction()
    data object ShowError : OnboardAction()
    data object None : OnboardAction()
}