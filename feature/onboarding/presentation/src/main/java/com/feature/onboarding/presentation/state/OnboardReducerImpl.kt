package com.feature.onboarding.presentation.state

import com.core.common.network.AppDispatchers
import com.core.common.network.Dispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OnboardReducerImpl @Inject constructor(
    @Dispatcher(AppDispatchers.Default) private val defaultDispatcher: CoroutineDispatcher
) : OnboardReducer {

    override val state = MutableStateFlow<OnboardState>(OnboardState.None)

    override suspend fun update(action: OnboardAction) {
        withContext(defaultDispatcher) {
            when (action) {
                OnboardAction.Load -> OnboardState.Loading
                is OnboardAction.SetContent -> onSetContent(action)
                OnboardAction.ShowError -> OnboardState.Error
                OnboardAction.None -> OnboardState.None
            }.also {
                state.value = it
            }
        }
    }

    private fun onSetContent(action: OnboardAction.SetContent): OnboardState {
        return when (val state = state.value) {
            is OnboardState.Content ->
                state.copy(text = updateState(action, state.text))

            else -> initialiseContent(action)
        }
    }

    private fun updateState(
        action: OnboardAction.SetContent,
        currentState: String,
    ): String {
        return "Update state"
    }

    private fun initialiseContent(action: OnboardAction.SetContent): OnboardState {
        return OnboardState.Content(action.text)
    }
}