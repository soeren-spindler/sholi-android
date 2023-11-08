package com.spindler.sholi.app.navigation

import junit.framework.TestCase
import org.junit.Test

class NavDestinationTests {

    @Test
    fun `when only baseRoute set expect route to be baseRoute`() {
        val expected = "basisRoute"
        val destination = NavDestination(baseRoute = expected)
        TestCase.assertEquals(expected, destination.route)
}
}