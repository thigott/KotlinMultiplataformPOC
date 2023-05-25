package com.thigott.kotlinmultiplataformpoc.navigation.navigation

import com.thigott.kotlinmultiplataformpoc.home.screen.HomeNavigation
import com.thigott.kotlinmultiplataformpoc.navigation.destination.core.NavigationManager
import com.thigott.kotlinmultiplataformpoc.navigation.destination.home.HomeRoutes
import com.thigott.kotlinmultiplataformpoc.navigation.destination.profile.ProfileRoutes

class HomeNavigationImpl(
    private val navigationManager: NavigationManager
): HomeNavigation {

    override fun goToProfileScreen() {
        navigationManager.navigate(
            route = ProfileRoutes.Profile.createRoute(),
            builder = {
                popUpTo(HomeRoutes.Home.createRoute()) {
                    inclusive = true
                }
            }
        )
    }
}