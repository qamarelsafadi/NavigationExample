package com.qamar.yassirnavigationexample.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.qamar.yassirnavigationexample.ui.navigation.HomeDestinations.HomeArgs.ID_ARGS
import com.qamar.yassirnavigationexample.ui.screens.DetailsScreen
import com.qamar.yassirnavigationexample.ui.screens.HomeScreen

/**
 * Destinations
 */
sealed class HomeDestinations(val route: String) {

    object HomeArgs {
        const val ID_ARGS = "idArgs"
    }

    object HomeScreens {
        const val HOME_SCREEN = "home-screen"
        const val DETAILS_SCREEN = "details-screen"
    }

    data object Home : HomeDestinations(HomeScreens.HOME_SCREEN)
    data object Details :
        HomeDestinations("${HomeScreens.DETAILS_SCREEN}/{$ID_ARGS}") {
        fun createRoute(id: Int): String {
            return "${HomeScreens.DETAILS_SCREEN}/$id"
        }
    }
}

/**
 * Navigation
 */

fun NavGraphBuilder.homeNavigation(navController: NavHostController) {
    navigation(
        route = NavGraphs.HOME_GRAPH,
        startDestination = HomeDestinations.Home.route
    ) {
        composable(
            route = HomeDestinations.Home.route,
        ) {
            HomeScreen(onFinish = navController::navigateToDetails)
        }

        composable(
            route = HomeDestinations.Details.route,
            arguments = listOf(navArgument(ID_ARGS) {
                type = NavType.IntType
            })
        ) {
            val id = it.arguments?.getInt(ID_ARGS, -1) ?: -1
            DetailsScreen(id = id)
        }
    }
}

/**
 * Navigation Actions
 */

fun NavHostController.navigateToDetails(id: Int) {
    navigate(HomeDestinations.Details.createRoute(id))
}
