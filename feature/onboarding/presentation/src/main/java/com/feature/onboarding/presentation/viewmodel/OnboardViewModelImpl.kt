package com.feature.onboarding.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.core.domain.onboarding.repository.OnboardingRepository
import com.core.domain.onboarding.usecase.GetRandomJokesUseCase
import com.feature.onboarding.presentation.state.OnboardAction
import com.feature.onboarding.presentation.state.OnboardReducer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardViewModelImpl @Inject constructor(
    private val onboardReducer: OnboardReducer,
    private val getRandomJokesUseCase: GetRandomJokesUseCase
) : OnboardViewModel() {

    override val state = onboardReducer.state

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