package com.feature.home.presentation.state

import com.core.common.network.AppDispatchers
import com.core.common.network.Dispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeScreenReducerImpl @Inject constructor(
    @Dispatcher(AppDispatchers.Default) private val defaultDispatcher: CoroutineDispatcher
) : HomeScreenReducer {

    private val _state = MutableStateFlow<HomeScreenState>(HomeScreenState.None)
    override val state = _state.asStateFlow()

    override suspend fun update(action: HomeScreenAction) {
        withContext(defaultDispatcher) {
            when (action) {
                HomeScreenAction.Load -> HomeScreenState.Loading
                is HomeScreenAction.SetContent -> onSetContent(action)
                HomeScreenAction.ShowError -> HomeScreenState.Error
                HomeScreenAction.None -> HomeScreenState.None
            }.also {
                _state.value = it
            }
        }
    }

    private fun onSetContent(action: HomeScreenAction.SetContent): HomeScreenState {
        return when (val state = state.value) {
            is HomeScreenState.Content ->
                state.copy(text = updateState())

            else -> initialiseContent(action)
        }
    }

    @Suppress("FunctionOnlyReturningConstant")
    private fun updateState(): String {
        return "Update state"
    }

    private fun initialiseContent(action: HomeScreenAction.SetContent): HomeScreenState {
        return HomeScreenState.Content(action.text)
    }
}
