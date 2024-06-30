package com.qamar.yassirnavigationexample.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.qamar.yassirnavigationexample.ui.screens.LoginScreen
import com.qamar.yassirnavigationexample.ui.screens.RegisterScreen
import com.qamar.yassirnavigationexample.ui.screens.SplashScreen

sealed class AuthDestinations(val route: String) {
    data object Login : AuthDestinations("login-screen")
    data object Register : AuthDestinations("register-screen")
}

fun NavGraphBuilder.authNavigationHost(navController: NavHostController) {
    navigation(
        route = NavGraphs.AUTH_GRAPH,
        startDestination = AuthDestinations.Login.route
    ) {
        composable(
            route = AuthDestinations.Login.route,
        ) {
            LoginScreen(onFinish = navController::navigateToRegister)
        }
        composable(
            route = AuthDestinations.Register.route,
        ) {
            RegisterScreen(onFinish = navController::navigateToHome)
        }
    }
}

/**
 * Navigation Actions
 */

fun NavHostController.navigateToRegister() {
    navigate(AuthDestinations.Register.route) {
        launchSingleTop = true
        popUpTo(graph.id) {
            inclusive = true
        }
    }
}

fun NavHostController.navigateToHome() {
    navigate(NavGraphs.HOME_GRAPH) {
        launchSingleTop = true
        popUpTo(graph.id) {
            inclusive = true
        }
    }
}
