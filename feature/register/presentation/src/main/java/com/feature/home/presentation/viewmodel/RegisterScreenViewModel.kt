package com.feature.onboarding.presentation.viewmodel

import RegistrationState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.domain.onboarding.model.SignUpParams
import com.core.domain.onboarding.usecase.SignUpUseCase
import com.feature.onboarding.presentation.state.register.RegisterReducer
import com.feature.onboarding.presentation.state.register.RegistrationAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val reducer: RegisterReducer,
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    val uiState = reducer.state

    fun onAction(action: RegistrationAction) {
        viewModelScope.launch {
            when (action) {
                RegistrationAction.RegisterButtonClicked -> registerUser()
                else -> reducer.update(action)
            }
        }
    }

    private suspend fun registerUser() {
        val currentState = uiState as StateFlow
        val validationError = validateInputs(currentState.value)
        if (validationError != null) {
            reducer.update(RegistrationAction.RegistrationFailed(validationError))
            return
        }

        reducer.update(RegistrationAction.RegistrationStarted)

        viewModelScope.launch {
            reducer.update(RegistrationAction.RegistrationStarted)
            try {
                signUpUseCase(SignUpParams(currentState.value.email, currentState.value.password))
                reducer.update(RegistrationAction.RegistrationSuccess("userId"))
                // _effect.emit(RegistrationEffect.NavigateToHome)
            } catch (e: Exception) {
                reducer.update(RegistrationAction.RegistrationFailed(e.localizedMessage ?: "Registration failed"))
            }
        }
    }

    private fun validateInputs(state: RegistrationState): String? {
        return when {
            state.email.isEmpty() -> "Email cannot be empty"
            !state.isValidEmail -> "Please enter a valid email"
            state.password.isEmpty() -> "Password cannot be empty"
            !state.isValidPassword -> "Password must be at least 6 characters"
            !state.passwordsMatch -> "Passwords don't match"
            state.name.isEmpty() -> "Name cannot be empty"
            !state.isValidName -> "Name must be at least 2 characters"
            else -> null
        }
    }


}