package com.feature.onboarding.ui.main

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
import com.feature.onboarding.presentation.state.OnboardState
import com.feature.onboarding.presentation.viewmodel.OnboardViewModel

@Composable
internal fun OnboardScreen(
    modifier: Modifier = Modifier,
    viewModel: OnboardViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle(initialValue = OnboardState.None)
    OnboardScreenRouter(state, modifier.fillMaxSize())
}

@Composable
fun OnboardScreenRouter(
    state: OnboardState,
    modifier: Modifier = Modifier
) {
    when (state) {
        OnboardState.Loading -> CommonLoader(modifier)
        is OnboardState.Content -> OnboardContent(state, modifier)
        OnboardState.Error,
        OnboardState.None -> Unit
    }
}

@Composable
fun OnboardContent(
    state: OnboardState.Content,
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
        OnboardScreenRouter(state = OnboardState.Content(text = "Hello Mobile"))
    }
}
