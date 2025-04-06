package com.core.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.feature.home.ui.main.navigation.homeScreen
import com.feature.home.ui.main.navigation.navigateToHome
import com.feature.register.ui.main.navigation.navigateToRegister
import com.feature.register.ui.main.navigation.registerScreen
import com.feature.signin.ui.main.navigation.SignInScreenRoute
import com.feature.signin.ui.main.navigation.navigateToSignIn
import com.feature.signin.ui.main.navigation.signInScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestinationScreen: Any = SignInScreenRoute
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestinationScreen
    ) {
        signInScreen(
            navigateToRegister = navController::navigateToRegister,
            navigateToHome = navController::navigateToHome
        )
        registerScreen(
            navigateToLogin = navController::navigateToSignIn,
            navigateToHome = navController::navigateToSignIn
        )
        homeScreen()
    }
}
