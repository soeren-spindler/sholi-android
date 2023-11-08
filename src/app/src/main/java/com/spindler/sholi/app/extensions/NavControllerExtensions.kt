package com.spindler.sholi.app.extensions

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.spindler.sholi.domain.util.ShoLiLog

object NavControllerExtensions {

    fun NavController.navigateTo(route: String) {
        navigate(route) {
            popUpTo(graph.findStartDestination().id) {
                ShoLiLog.i("NavControllerExtensions", "popUp and save state")
                saveState = true
                // inclusive = true
            }
            restoreState = true
            //launchSingleTop = true
        }
    }
}