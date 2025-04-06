package com.feature.register.presentation.state.register

import RegistrationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class RegisterReducerImpl @Inject constructor() : RegisterReducer {
    private val _state = MutableStateFlow(RegistrationState())
    override val state = _state.asStateFlow()

    override suspend fun update(action: RegistrationAction) {
        when (action) {
            is RegistrationAction.NameChanged -> {
                _state.update { it.copy(name = action.name) }
            }

            is RegistrationAction.EmailChanged -> {
                _state.update { it.copy(email = action.email) }
            }

            is RegistrationAction.PasswordChanged -> {
                _state.update { it.copy(password = action.password) }
            }

            is RegistrationAction.ConfirmPasswordChanged -> {
                _state.update { it.copy(confirmPassword = action.confirmPassword) }
            }

            RegistrationAction.RegisterButtonClicked -> {
                _state.update { it.copy(isRegistering = true, errorMessage = null) }
            }

            RegistrationAction.RegistrationStarted -> {
                _state.update { it.copy(isRegistering = true, errorMessage = null) }
            }

            is RegistrationAction.RegistrationSuccess -> {
                _state.update { it.copy(isRegistering = false, registrationSuccess = true, errorMessage = null) }
            }

            is RegistrationAction.RegistrationFailed -> {
                _state.update { it.copy(isRegistering = false, errorMessage = action.error) }
            }

            RegistrationAction.ClearError -> {
                _state.update { it.copy(errorMessage = null) }
            }

            RegistrationAction.OnAlreadyHaveAccountClick -> Unit
            else -> Unit
        }
    }
}
