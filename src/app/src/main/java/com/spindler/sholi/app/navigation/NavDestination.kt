package com.spindler.sholi.app.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

open class NavDestination(
    private val baseRoute: String,
    arguments: List<String> = listOf()
) {
    val route: String

    val navArguments: List<NamedNavArgument>

    init {
        route =
            if (arguments.isEmpty()) {
                baseRoute
            } else {
                val routeArgs = buildRouteArguments(arguments)
                "$baseRoute?$routeArgs"
            }

        navArguments = arguments
            .map { arg ->
                navArgument(arg) {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            }
    }

    fun routeWithArguments(vararg arguments: Pair<String, String>): String {
        val routeArgs = buildRouteArguments(
            arguments.map { arg -> arg.first }
        ) { argumentName ->
            arguments.single { it.first == argumentName }.second
        }
        return "$baseRoute?$routeArgs"
    }

    private fun buildRouteArguments(
        argumentNames: List<String>,
        valueSelector: (argumentName: String) -> String = { "{$it}" }
    ): String =
        argumentNames
            .joinToString(separator = "&") { argumentName ->
                "$argumentName=${valueSelector(argumentName)}"
            }
}