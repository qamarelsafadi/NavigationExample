package com.qamar.yassirnavigationexample.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.qamar.yassirnavigationexample.ui.screens.SplashScreen

sealed class OnBoardingDestinations(val route: String) {
    data object Splash : OnBoardingDestinations("splash-screen")
}

fun NavGraphBuilder.onBoardingNavigation(navController: NavHostController) {
    navigation(
        route = NavGraphs.ON_BOARDING_GRAPH,
        startDestination = OnBoardingDestinations.Splash.route
    ) {
        composable(
            route = OnBoardingDestinations.Splash.route,
        ) {
            SplashScreen(onFinish = navController::navigateToOnLogin)
        }
    }
}

/**
 * Navigation Actions
 */

fun NavHostController.navigateToOnLogin() {
    navigate(NavGraphs.AUTH_GRAPH) {
        launchSingleTop = true
        popUpTo(graph.id) {
            inclusive = true
        }
    }
}
