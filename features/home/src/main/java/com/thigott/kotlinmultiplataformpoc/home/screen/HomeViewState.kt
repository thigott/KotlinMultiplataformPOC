package com.thigott.kotlinmultiplataformpoc.home.screen

data class HomeViewState(
    val isLoading: Boolean = false,
    val username: String = "",
    val password: String = "",
    val error: String = "",
    val success: String = ""
)