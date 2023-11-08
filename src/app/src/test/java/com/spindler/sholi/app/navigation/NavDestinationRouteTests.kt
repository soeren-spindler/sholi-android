package com.spindler.sholi.app.navigation

import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class NavDestinationRouteTests(
    private val expectedRoute: String,
    private val destination: NavDestination
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun routesAndArguments(): Collection<Array<Any>> =
            listOf(
                arrayOf(
                    "oneRoute?id={id}",
                    NavDestination("oneRoute", listOf("id"))
                ),
                arrayOf(
                    "twoRoute?id={id}&name={name}",
                    NavDestination("twoRoute", listOf("id", "name"))
                ),
                arrayOf(
                    "threeRoute?id={id}&name={name}&age={age}",
                    NavDestination("threeRoute", listOf("id", "name", "age"))
                )
            )
    }

    @Test
    fun `when baseRoute & arguments given expect route to be set`() {
        TestCase.assertEquals(expectedRoute, destination.route)
    }
}