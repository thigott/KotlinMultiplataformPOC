pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "KotlinMultiplataformPOC"
include(":androidApp")
include(":shared")
include(":uikit")
include(":features:home")
include(":navigation")
include(":di")
