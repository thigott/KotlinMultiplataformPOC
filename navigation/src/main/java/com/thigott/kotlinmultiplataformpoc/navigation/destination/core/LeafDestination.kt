package com.thigott.kotlinmultiplataformpoc.navigation.destination.core

import androidx.navigation.NamedNavArgument
import com.google.gson.Gson

open class LeafDestination(
    val root: Destination,
    private val route: String
) {
    private val gson = Gson()
    fun Any?.toGson(): String = gson.toJson(this)

    open val arguments: List<NamedNavArgument> = listOf()
    fun createRoute() = "${root.route}/$route"
}