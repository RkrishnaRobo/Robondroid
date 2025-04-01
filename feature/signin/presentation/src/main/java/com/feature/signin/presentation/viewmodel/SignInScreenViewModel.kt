package com.feature.signin.presentation.viewmodel

import NavigationState
import SignInState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.domain.onboarding.model.SignUpParams
import com.core.domain.onboarding.usecase.SignInUseCase
import com.feature.signin.presentation.state.SignInAction
import com.feature.signin.presentation.state.SignInReducer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInScreenViewModel @Inject constructor(
    private val reducer: SignInReducer,
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    val uiState = reducer.state

    private val _navigationState = MutableStateFlow<NavigationState>(NavigationState.None)
    val navigationState = _navigationState.asStateFlow()

    fun onAction(action: SignInAction) {
        viewModelScope.launch {
            when (action) {
                SignInAction.OnSignInClicked -> signInUser()
                SignInAction.OnNotMemberClicked -> goToRegister()
                else -> reducer.update(action)
            }
        }
    }

    fun resetNavigation() {
        _navigationState.update { NavigationState.None }
    }

    private fun goToRegister() {
        _navigationState.update { NavigationState.NavigateToRegister }
    }

    private suspend fun signInUser() {
        val currentState = uiState as StateFlow
        val validationError = validateInputs(currentState.value)
        if (validationError != null) {
            reducer.update(SignInAction.SignInFailed(validationError))
            return
        }

        viewModelScope.launch {
            reducer.update(SignInAction.SignInStarted)
            signInUseCase(SignUpParams(currentState.value.email, currentState.value.password))
                .onSuccess {
                    _navigationState.update { NavigationState.NavigateToHome }
                }.onFailure { e ->
                    reducer.update(SignInAction.SignInFailed(e.localizedMessage ?: "SignIn failed"))
                }
        }
    }

    private fun validateInputs(state: SignInState): String? {
        return when {
            state.email.isEmpty() -> "Email cannot be empty"
            !state.isValidEmail -> "Please enter a valid email"
            state.password.isEmpty() -> "Password cannot be empty"
            !state.isValidPassword -> "Password must be at least 6 characters"
            else -> null
        }
    }
}
