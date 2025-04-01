package com.feature.register.ui.main.onboard.register

import RegistrationState
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
import androidx.compose.material.icons.outlined.Face
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.core.designsystem.component.common.HeaderWrapper
import com.core.designsystem.component.textfield.DefaultTextField
import com.core.designsystem.component.textfield.PasswordTextField
import com.core.ui.component.loader.CommonLoader
import com.feature.home.presentation.state.register.RegistrationAction
import com.feature.home.presentation.viewmodel.RegisterScreenViewModel
import com.feature.onboarding.ui.main.R

@Composable
fun RegisterScreen(
    navigateToHome: () -> Unit,
    navigateToLogin: () -> Unit,
    modifier: Modifier = Modifier,
    registerScreenViewModel: RegisterScreenViewModel = hiltViewModel()
) {
    val uiState by registerScreenViewModel.uiState.collectAsStateWithLifecycle(RegistrationState())

    val navigationState by registerScreenViewModel.navigationState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = navigationState) {
        fun performNavigation(action: () -> Unit) {
            action()
            registerScreenViewModel.resetNavigation()
        }

        when (navigationState) {
            is NavState.NavigateToHome -> performNavigation(navigateToHome)
            is NavState.NavigateToLogin -> performNavigation(navigateToLogin)
            else -> Unit
        }
    }
    RegisterScreenContent(
        uiState,
        registerScreenViewModel::onAction,
        modifier,
    )
}

@Suppress("DestructuringDeclarationWithTooManyEntries")
@Composable
fun RegisterScreenContent(
    uiState: RegistrationState,
    onAction: (RegistrationAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val (
        fullNameFocusRequester,
        emailFocusRequester,
        passwordFocusRequester,
        confirmPasswordFocusRequester,
    ) = FocusRequester.createRefs()

    if (uiState.isRegistering) {
        CommonLoader()
    } else {
        Column(
            modifier = modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RegisterHeader()
            RegisterTextFieldSection(
                uiState = uiState,
                fullNameFocusRequester = fullNameFocusRequester,
                emailFocusRequester = emailFocusRequester,
                passwordFocusRequester = passwordFocusRequester,
                confirmPasswordFocusRequester = confirmPasswordFocusRequester,
                onAction = onAction
            )
        }
    }
}

@Suppress("LongMethod")
@Composable
fun RegisterTextFieldSection(
    uiState: RegistrationState,
    onAction: (RegistrationAction) -> Unit,
    fullNameFocusRequester: FocusRequester,
    emailFocusRequester: FocusRequester,
    passwordFocusRequester: FocusRequester,
    confirmPasswordFocusRequester: FocusRequester,
    modifier: Modifier = Modifier,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
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
            value = uiState.name,
            label = R.string.full_name,
            leadingIcon = Icons.Outlined.Face,
            onValueChange = { onAction(RegistrationAction.NameChanged(it)) },
            modifier = Modifier.focusRequester(fullNameFocusRequester),
            keyboardActions = KeyboardActions(onNext = { emailFocusRequester.requestFocus() }),
        )
        DefaultTextField(
            value = uiState.email,
            label = R.string.email,
            leadingIcon = Icons.Outlined.Email,
            onValueChange = { onAction(RegistrationAction.EmailChanged(it)) },
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
            label = R.string.password,
            onValueChange = { onAction(RegistrationAction.PasswordChanged(it)) },
            modifier = Modifier.focusRequester(passwordFocusRequester),
            keyboardActions = KeyboardActions(onNext = { confirmPasswordFocusRequester.requestFocus() }),
        )
        PasswordTextField(
            value = uiState.confirmPassword,
            icon = Icons.Outlined.Lock,
            label = R.string.repeat_password,
            onValueChange = { onAction(RegistrationAction.ConfirmPasswordChanged(it)) },
            modifier = Modifier.focusRequester(confirmPasswordFocusRequester),
            keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            ),
            keyboardActions =
            KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    onAction(RegistrationAction.RegisterButtonClicked)
                },
            ),
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onAction(RegistrationAction.RegisterButtonClicked) },
            modifier = Modifier.fillMaxWidth(),
            enabled = !uiState.isRegistering
        ) {
            if (uiState.isRegistering) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    strokeWidth = 2.dp
                )
            } else {
                Text("Register", modifier = Modifier.padding(4.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp),
        ) {
            Text(
                text = stringResource(id = R.string.already_have_account),
                style = MaterialTheme.typography.titleMedium,
            )
            TextButton(onClick = { onAction(RegistrationAction.OnAlreadyHaveAccountClick) }) {
                Text(
                    text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}

@Composable
private fun RegisterHeader(modifier: Modifier = Modifier) {
    HeaderWrapper(modifier = modifier) {
        Text(
            text = stringResource(R.string.register_header),
            style = MaterialTheme.typography.displaySmall,
        )
    }
}
