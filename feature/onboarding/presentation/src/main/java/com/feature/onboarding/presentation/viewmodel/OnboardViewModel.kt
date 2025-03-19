package com.feature.onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.domain.onboarding.usecase.GetRandomJokesUseCase
import com.feature.onboarding.presentation.state.OnboardAction
import com.feature.onboarding.presentation.state.OnboardReducer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(
    private val onboardReducer: OnboardReducer,
    private val getRandomJokesUseCase: GetRandomJokesUseCase
) : ViewModel() {

    val uiState = onboardReducer.state

    init {
        loadJokes()
    }

    private fun loadJokes() {
        viewModelScope.launch {
            onboardReducer.update(OnboardAction.Load)
            getRandomJokesUseCase().onSuccess { randomJoke ->
                onboardReducer.update(OnboardAction.SetContent(text = randomJoke.punchline))
            }.onFailure {
                onboardReducer.update(OnboardAction.ShowError)
            }
        }
    }
}
