plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.thigott.kotlinmultiplataformpoc.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.thigott.kotlinmultiplataformpoc.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":uikit"))
    implementation(project(":navigation"))
    implementation(project(":di"))
    implementation(libs.bundles.compose)
    implementation(libs.bundles.koin)
    implementation(libs.composeNavigation)
    implementation(libs.kmmLibrary)
}