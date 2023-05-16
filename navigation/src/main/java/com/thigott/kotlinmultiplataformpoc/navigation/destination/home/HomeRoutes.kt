package com.thigott.kotlinmultiplataformpoc.navigation.destination.home

import com.thigott.kotlinmultiplataformpoc.navigation.destination.core.Destination
import com.thigott.kotlinmultiplataformpoc.navigation.destination.core.LeafDestination


object HomeRoutes {
    object Home : LeafDestination(root = Destination.Home, route = "home")
}