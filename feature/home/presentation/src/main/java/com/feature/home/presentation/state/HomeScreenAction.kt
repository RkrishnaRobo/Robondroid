package com.feature.home.presentation.state

import com.core.common.state.Action

sealed class HomeScreenAction : Action {
    data object Load : HomeScreenAction()
    data class SetContent(val text: String) : HomeScreenAction()
    data object ShowError : HomeScreenAction()
    data object None : HomeScreenAction()
}
