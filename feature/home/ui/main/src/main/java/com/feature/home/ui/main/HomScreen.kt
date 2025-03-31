package com.feature.home.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.core.designsystem.theme.RobondroidTheme
import com.core.ui.component.loader.CommonLoader
import com.feature.home.presentation.state.HomeScreenState
import com.feature.home.presentation.viewmodel.HomeScreenViewModel

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle(initialValue = HomeScreenState.None)
    OnboardScreenRouter(state, modifier.fillMaxSize())
}

@Composable
fun OnboardScreenRouter(
    state: HomeScreenState,
    modifier: Modifier = Modifier
) {
    when (state) {
        HomeScreenState.Loading -> CommonLoader(modifier)
        is HomeScreenState.Content -> OnboardContent(state, modifier)
        HomeScreenState.Error,
        HomeScreenState.None -> Unit
    }
}

@Composable
fun OnboardContent(
    state: HomeScreenState.Content,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = state.text,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Preview
@Composable
@Preview(showBackground = true)
private fun OnboardScreenPreview() {
    RobondroidTheme {
        OnboardScreenRouter(state = HomeScreenState.Content(text = "Hello Mobile"))
    }
}
