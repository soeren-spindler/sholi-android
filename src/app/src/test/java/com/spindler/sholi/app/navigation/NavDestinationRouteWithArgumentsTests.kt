package com.spindler.sholi.app.navigation

import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class NavDestinationRouteWithArgumentsTests(
    private val expectedRoute: String,
    private val destination: NavDestination,
    private val arguments: Array<Pair<String, String>>
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun routesAndArguments(): Collection<Array<Any>> =
            listOf(
                arrayOf(
                    "oneRoute?id=hamster",
                    NavDestination("oneRoute", listOf("id")),
                    arrayOf(("id" to "hamster"))
                ),
                arrayOf(
                    "twoRoute?id=whatever&name=my-name-is",
                    NavDestination("twoRoute", listOf("id", "name")),
                    arrayOf(("id" to "whatever"), ("name" to "my-name-is"))
                ),
                arrayOf(
                    "threeRoute?id=007&name=James Bond&age=12",
                    NavDestination("threeRoute", listOf("id", "name", "age")),
                    arrayOf(
                        ("id" to "007"),
                        ("name" to "James Bond"),
                        ("age" to "12")
                    )
                )
            )
    }

    @Test
    fun `when baseRoute & arguments given expect routeWithArguments to be set`() {
        TestCase.assertEquals(expectedRoute, destination.routeWithArguments(*arguments))
    }
}