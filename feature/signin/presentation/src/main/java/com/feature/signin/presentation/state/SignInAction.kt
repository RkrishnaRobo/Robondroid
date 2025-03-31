package com.feature.signin.presentation.state

import com.core.common.state.Action

sealed class SignInAction : Action {
    data class EmailChanged(val email: String) : SignInAction()
    data class PasswordChanged(val password: String) : SignInAction()
    data object SignInStarted : SignInAction()
    data object OnSignInClicked : SignInAction()
    data class SignInFailed(val error: String) : SignInAction()
    data object OnNotMemberClicked : SignInAction()
}
