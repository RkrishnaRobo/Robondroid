package com.feature.onboarding.ui.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.feature.onboarding.ui.main.OnboardScreen
import kotlinx.serialization.Serializable

@Serializable
data object OnboardScreenRoute

fun NavController.navigateToOnboard(navOptions: NavOptions? = null) {
    navigate(OnboardScreenRoute, navOptions)
}

fun NavGraphBuilder.onboardScreen() {
    composable<OnboardScreenRoute> {
        OnboardScreen()
    }
}