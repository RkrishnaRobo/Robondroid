package com.feature.onboarding.presentation.state.register

import com.core.common.state.Action

sealed class RegistrationAction : Action {
    data class NameChanged(val name: String) : RegistrationAction()
    data class EmailChanged(val email: String) : RegistrationAction()
    data class PasswordChanged(val password: String) : RegistrationAction()
    data class ConfirmPasswordChanged(val confirmPassword: String) : RegistrationAction()
    data object RegisterButtonClicked : RegistrationAction()
    data object RegistrationStarted : RegistrationAction()
    data class RegistrationSuccess(val userId: String) : RegistrationAction()
    data class RegistrationFailed(val error: String) : RegistrationAction()
    data object ClearError : RegistrationAction()
}
