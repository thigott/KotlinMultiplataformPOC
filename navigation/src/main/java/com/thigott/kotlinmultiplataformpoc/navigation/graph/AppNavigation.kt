package com.thigott.kotlinmultiplataformpoc.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.thigott.kotlinmultiplataformpoc.navigation.destination.core.Destination

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Home.route
    ) {
        addHomeNavGraph()
    }
}