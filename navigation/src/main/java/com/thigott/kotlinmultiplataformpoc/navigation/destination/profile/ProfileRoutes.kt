package com.thigott.kotlinmultiplataformpoc.navigation.destination.profile

import com.thigott.kotlinmultiplataformpoc.navigation.destination.core.Destination
import com.thigott.kotlinmultiplataformpoc.navigation.destination.core.LeafDestination

object ProfileRoutes {

    object Profile : LeafDestination(root = Destination.Profile, route = "profile")
}