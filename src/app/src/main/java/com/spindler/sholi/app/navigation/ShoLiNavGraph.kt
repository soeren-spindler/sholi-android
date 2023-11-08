package com.spindler.sholi.app.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.spindler.sholi.app.ui.composable.TestSettings
import com.spindler.sholi.app.ui.screen.HomeScreen
import com.spindler.sholi.app.ui.screen.ShoppingListEditScreen


data object ShoLiNavGraph {

    data object Main : NavDestination(baseRoute = "main") {

        data object Home : NavDestination(baseRoute = "home")

        data object Settings : NavDestination(baseRoute = "settings")

        data object EditShoppingList : NavDestination(
            baseRoute = "editShoppingList",
            arguments = listOf("id")
        )
    }
}

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
    route: String
) {
    navigation(
        route = route,
        startDestination = ShoLiNavGraph.Main.Home.route
    ) {

        composable(route = ShoLiNavGraph.Main.Home.route) {
            HomeScreen(
                onCreateShoppingListClicked = {
                    navController.navigate(
                        route = ShoLiNavGraph.Main.EditShoppingList.route
                    ) {
                        launchSingleTop = true
                    }
                },
                onSettingsClicked = {
                    navController.navigate(
                        route = ShoLiNavGraph.Main.Settings.route
                    ) {
                        launchSingleTop = true
                    }
                },
                onNavigateToShoppingList = { id ->
                    navController.navigate(
                        route = ShoLiNavGraph.Main.EditShoppingList.routeWithArguments(("id" to id))
                    ) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = ShoLiNavGraph.Main.EditShoppingList.route,
            arguments = ShoLiNavGraph.Main.EditShoppingList.navArguments
        ) {
            ShoppingListEditScreen(
                onNavigateBack = {
                    navController.navigateUp()
                },
                onNavigateAfterSaved = {
                    navController.navigate(ShoLiNavGraph.Main.Home.route)
                }
            )
        }

        composable(route = ShoLiNavGraph.Main.Settings.route) {
            TestSettings(
                onNavigateBack = { navController.navigateUp() }
            )
        }
    }
}
