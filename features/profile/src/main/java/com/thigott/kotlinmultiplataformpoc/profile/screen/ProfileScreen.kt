package com.thigott.kotlinmultiplataformpoc.profile.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileScreen() {
    BackHandler {}

    Scaffold {
        Box(
            modifier = Modifier.padding(it)
        ) {
            ProfileContent()
        }
    }
}

@Composable
private fun ProfileContent() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Profile screen")
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    Scaffold {
        Box(
            modifier = Modifier.padding(it)
        ) {
            ProfileContent()
        }
    }
}