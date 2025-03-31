package com.feature.signin.ui.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.feature.signin.ui.main.SignInScreen
import kotlinx.serialization.Serializable

@Serializable
data object SignInScreenRoute

fun NavController.navigateToSignIn(navOptions: NavOptions? = null) {
    navigate(SignInScreenRoute, navOptions)
}

fun NavGraphBuilder.signInScreen(
    navigateToHome: () -> Unit,
    navigateToRegister: () -> Unit
) {
    composable<SignInScreenRoute> {
        SignInScreen(
            navigateToHome = navigateToHome,
            navigateToRegister = navigateToRegister
        )
    }
}
