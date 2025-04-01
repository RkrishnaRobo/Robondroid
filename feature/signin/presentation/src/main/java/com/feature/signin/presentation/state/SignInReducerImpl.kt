package com.feature.signin.presentation.state

import SignInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class SignInReducerImpl @Inject constructor() : SignInReducer {
    private val _state = MutableStateFlow(SignInState())
    override val state = _state.asStateFlow()

    override suspend fun update(action: SignInAction) {
        when (action) {
            is SignInAction.EmailChanged -> {
                _state.update { it.copy(email = action.email) }
            }

            is SignInAction.PasswordChanged -> {
                _state.update { it.copy(password = action.password) }
            }

            SignInAction.OnSignInClicked -> {
                _state.update { it.copy(isLoading = true, errorMessage = "") }
            }

            is SignInAction.SignInFailed -> {
                _state.update { it.copy(isLoading = false, errorMessage = action.error) }
            }

            SignInAction.SignInStarted -> _state.update { it.copy(isLoading = true, errorMessage = "") }
            SignInAction.OnNotMemberClicked -> _state
        }
    }
}
