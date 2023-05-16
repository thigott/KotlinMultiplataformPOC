package com.thigott.kotlinmultiplataformpoc.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {
    val viewState = viewModel.viewState

    Scaffold {
        Box(
            modifier = Modifier.padding(it)
        ) {
            HomeContent(
                isLoading = viewState.isLoading,
                requestData = viewState.requestData
            )
        }
    }
}

@Composable
private fun HomeContent(
    isLoading: Boolean = false,
    requestData: String = ""
) {
    if (isLoading) {
        HomeLoadingIndicator()
    } else {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = requestData)
        }
    }
}

@Composable
private fun HomeLoadingIndicator() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.align(alignment = Alignment.Center),
            color = MaterialTheme.colors.primary
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    Scaffold {
        Box(modifier = Modifier.padding(it)) {
            HomeScreen()
        }
    }
}