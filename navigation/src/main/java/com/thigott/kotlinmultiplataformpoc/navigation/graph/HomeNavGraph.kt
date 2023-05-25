package com.thigott.kotlinmultiplataformpoc.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.thigott.kotlinmultiplataformpoc.home.screen.HomeScreen
import com.thigott.kotlinmultiplataformpoc.navigation.destination.core.Destination
import com.thigott.kotlinmultiplataformpoc.navigation.destination.home.HomeRoutes
import com.thigott.kotlinmultiplataformpoc.navigation.destination.profile.ProfileRoutes
import com.thigott.kotlinmultiplataformpoc.profile.screen.ProfileScreen

internal fun NavGraphBuilder.addHomeNavGraph() {
    navigation(
        route = Destination.Home.route,
        startDestination = HomeRoutes.Home.createRoute()
    ) {
        composable(
            route = HomeRoutes.Home.createRoute(),
            content = {
                HomeScreen()
            }
        )

        composable(
            route = ProfileRoutes.Profile.createRoute(),
            content = {
                ProfileScreen()
            }
        )
    }
}