package com.thigott.kotlinmultiplataformpoc

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform