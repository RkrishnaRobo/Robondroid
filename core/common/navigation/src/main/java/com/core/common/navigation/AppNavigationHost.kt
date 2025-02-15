package com.core.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.feature.onboarding.ui.main.navigation.OnboardScreenRoute
import com.feature.onboarding.ui.main.navigation.onboardScreen

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestinationScreen: Any = OnboardScreenRoute
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestinationScreen
    ) {
        onboardScreen()
    }
}