package com.spindler.sholi.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.spindler.sholi.domain.util.ShoLiLog

@Composable
fun ShoLiNavHost(
    navController: NavHostController
) {
    ShoLiLog.i("ShoLiNavHost", "recompose ShoLiNavHost")

    NavHost(
        navController = navController,
        startDestination = ShoLiNavGraph.Main.route
    ) {
        mainNavGraph(
            navController = navController,
            route = ShoLiNavGraph.Main.route
        )
    }
}
