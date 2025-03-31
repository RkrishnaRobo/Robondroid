package com.feature.home.presentation.state

import com.core.common.state.State

sealed class HomeScreenState : State {
    data object Loading : HomeScreenState()
    data class Content(val text: String) : HomeScreenState()
    data object Error : HomeScreenState()
    data object None : HomeScreenState()
}
