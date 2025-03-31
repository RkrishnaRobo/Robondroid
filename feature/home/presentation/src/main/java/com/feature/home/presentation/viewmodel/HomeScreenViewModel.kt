package com.feature.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.domain.onboarding.usecase.GetRandomJokesUseCase
import com.feature.home.presentation.state.HomeScreenAction
import com.feature.home.presentation.state.HomeScreenReducer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val onboardReducer: HomeScreenReducer,
    private val getRandomJokesUseCase: GetRandomJokesUseCase
) : ViewModel() {

    val uiState = onboardReducer.state

    init {
        loadJokes()
    }

    private fun loadJokes() {
        viewModelScope.launch {
            onboardReducer.update(HomeScreenAction.Load)
            getRandomJokesUseCase()
                .onSuccess { randomJoke ->
                    onboardReducer.update(HomeScreenAction.SetContent(text = randomJoke.punchline))
                }.onFailure {
                    onboardReducer.update(HomeScreenAction.ShowError)
                }
        }
    }
}
