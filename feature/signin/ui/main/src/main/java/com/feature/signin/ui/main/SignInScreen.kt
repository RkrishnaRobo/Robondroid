package com.feature.signin.ui.main

import SignInState
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.core.designsystem.component.common.HeaderWrapper
import com.core.designsystem.component.textfield.DefaultTextField
import com.core.designsystem.component.textfield.PasswordTextField
import com.core.ui.component.loader.CommonLoader
import com.feature.signin.presentation.state.SignInAction
import com.feature.signin.presentation.viewmodel.SignInScreenViewModel

@Composable
fun SignInScreen(
    navigateToHome: () -> Unit,
    navigateToRegister: () -> Unit,
    modifier: Modifier = Modifier,
    signInScreenViewModel: SignInScreenViewModel = hiltViewModel()
) {
    val uiState by signInScreenViewModel.uiState.collectAsStateWithLifecycle(SignInState())
    val navigationState by signInScreenViewModel.navigationState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = navigationState) {
        fun performNavigation(action: () -> Unit) {
            action()
            signInScreenViewModel.resetNavigation()
        }

        when (navigationState) {
            is NavigationState.NavigateToHome -> performNavigation(navigateToHome)
            else -> Unit
        }
    }
    RegisterScreenContent(
        uiState,
        signInScreenViewModel::onAction,
        modifier,
    )
}

@Composable
fun RegisterScreenContent(
    uiState: SignInState,
    onAction: (SignInAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val (
        emailFocusRequester,
        passwordFocusRequester,
    ) = FocusRequester.createRefs()

    if (uiState.isLoading) {
        CommonLoader()
    } else {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginHeader()
            LoginForm(
                modifier = modifier,
                uiState = uiState,
                emailFocusRequester = emailFocusRequester,
                passwordFocusRequester = passwordFocusRequester,
                onAction = onAction
            )
        }
    }
}

@Composable
fun LoginForm(
    uiState: SignInState,
    onAction: (SignInAction) -> Unit,
    emailFocusRequester: FocusRequester,
    passwordFocusRequester: FocusRequester,
    modifier: Modifier = Modifier,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = modifier.padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        AnimatedVisibility(visible = uiState.errorMessage != null) {
            Text(
                text = uiState.errorMessage ?: "",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        DefaultTextField(
            value = uiState.email,
            label = com.core.designsystem.R.string.email,
            leadingIcon = Icons.Outlined.Email,
            onValueChange = { onAction(SignInAction.EmailChanged(it)) },
            modifier = Modifier.focusRequester(emailFocusRequester),
            keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions(onNext = { passwordFocusRequester.requestFocus() }),
        )
        PasswordTextField(
            value = uiState.password,
            icon = Icons.Outlined.Lock,
            label = com.core.designsystem.R.string.password,
            onValueChange = { onAction(SignInAction.PasswordChanged(it)) },
            modifier = Modifier.focusRequester(passwordFocusRequester),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    onAction(SignInAction.OnSignInClicked)
                },
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.not_a_member),
                style = MaterialTheme.typography.titleMedium
            )
            TextButton(onClick = { onAction(SignInAction.OnNotMemberClicked) }) {
                Text(
                    text = stringResource(id = R.string.register_now),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { onAction(SignInAction.OnSignInClicked) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            enabled = !uiState.isLoading
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    strokeWidth = 2.dp
                )
            } else {
                Text("Login", modifier = Modifier.padding(4.dp))
            }
        }
    }
}

@Composable
private fun LoginHeader(modifier: Modifier = Modifier) {
    HeaderWrapper(modifier = modifier) {
        Text(
            text = stringResource(R.string.login_header),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(R.string.login_sub_header),
            style = MaterialTheme.typography.titleMedium,
            minLines = 1,
            textAlign = TextAlign.Center
        )
    }
}


