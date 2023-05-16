package com.thigott.kotlinmultiplataformpoc.navigation.destination.core

sealed class Destination(val route: String) {
    object Home : Destination(route = "home")
}