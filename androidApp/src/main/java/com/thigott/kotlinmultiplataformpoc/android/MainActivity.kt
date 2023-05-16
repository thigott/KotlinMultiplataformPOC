package com.thigott.kotlinmultiplataformpoc.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thigott.kotlinmultiplataformpoc.navigation.graph.AppNavigation
import com.thigott.kotlinmultiplataformpoc.uikit.theme.Theme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Theme {
                val navHostController: NavHostController = rememberNavController()
                viewModel.initNavigation(navHostController = navHostController)
                AppNavigation(navController = navHostController)
            }
        }
    }
}