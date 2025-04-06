package com.feature.register.ui.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.feature.register.ui.main.RegisterScreen
import kotlinx.serialization.Serializable

@Serializable
data object RegisterScreenRoute

fun NavController.navigateToRegister(navOptions: NavOptions? = null) {
    navigate(RegisterScreenRoute, navOptions)
}

fun NavGraphBuilder.registerScreen(
    navigateToHome: () -> Unit,
    navigateToLogin: () -> Unit
) {
    composable<RegisterScreenRoute> {
        RegisterScreen(
            navigateToHome = navigateToHome,
            navigateToLogin = navigateToLogin
        )
    }
}
