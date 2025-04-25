package org.sopt.at.presentation.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.presentation.R
import org.sopt.at.presentation.component.AtSoptButton
import org.sopt.at.presentation.component.AtSoptPasswordTextField
import org.sopt.at.presentation.component.AtSoptTextField
import org.sopt.at.presentation.component.AtSoptTopBar
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.ui.theme.AtSoptTheme

@Composable
fun SignUpRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateSignIn: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current
    val snackBarHost = remember { SnackbarHostState() }
    val context = LocalContext.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is SignUpSideEffect.NavigateUp -> navigateUp()
                is SignUpSideEffect.NavigateSignIn -> navigateSignIn()
                is SignUpSideEffect.SnackBar -> {
                    snackBarHost.currentSnackbarData?.dismiss()
                    snackBarHost.showSnackbar(
                        message = context.getString(sideEffect.message)
                    )
                }
            }
        }
    }

    SignUpScreen(
        paddingValues = paddingValues,
        state = state,
        navigateUp = navigateUp,
        navigateSignIn = viewModel::navigateSignIn,
        navigatePassword = viewModel::updateIdScreen,
        onIdChange = viewModel::updateId,
        onPasswordChange = viewModel::updatePassword
    )
}

@Composable
fun SignUpScreen(
    paddingValues: PaddingValues,
    state: SignUpState,
    navigateUp: () -> Unit,
    navigateSignIn: () -> Unit,
    navigatePassword: () -> Unit,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {
    if(state.isIdScreen) {
        IdScreen(
            paddingValues = paddingValues,
            id = state.uiState.id,
            isEnabled = state.isIdEnabled,
            onIdChange = onIdChange,
            navigateUp = navigateUp,
            navigatePassword = navigatePassword
        )
    } else {
        PasswordScreen(
            paddingValues = paddingValues,
            password = state.uiState.password,
            isEnabled = state.isPasswordEnabled,
            onPasswordChange = onPasswordChange,
            navigateUp = navigateUp,
            navigateSignIn = navigateSignIn
        )
    }
}

@Composable
fun IdScreen(
    paddingValues: PaddingValues,
    id: String,
    isEnabled: Boolean,
    onIdChange: (String) -> Unit,
    navigateUp: () -> Unit,
    navigatePassword: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AtSoptTheme.colors.backgroundPrimary)
            .padding(paddingValues)
    ) {
        AtSoptTopBar(
            onBackButtonClick = navigateUp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.signup_id),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = AtSoptTheme.colors.textPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        AtSoptTextField(
            value = id,
            onValueChange = onIdChange,
            placeholder = stringResource(R.string.id),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.signup_id_descrption),
            fontSize = 12.sp,
            color = AtSoptTheme.colors.textSecondary,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(Modifier.weight(1f))

        AtSoptButton(
            text = stringResource(R.string.next),
            backgroundColor = AtSoptTheme.colors.dividerPrimary,
            onClick = {
                if (isEnabled) navigatePassword()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            isEnabled = isEnabled,
            borderColor = AtSoptTheme.colors.textPrimary
        )
    }
}

@Composable
fun PasswordScreen(
    paddingValues: PaddingValues,
    password: String,
    isEnabled: Boolean,
    onPasswordChange: (String) -> Unit,
    navigateUp: () -> Unit,
    navigateSignIn: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AtSoptTheme.colors.backgroundPrimary)
            .padding(paddingValues)
    ) {
        AtSoptTopBar(
            onBackButtonClick = navigateUp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.signup_password),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = AtSoptTheme.colors.textPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        AtSoptPasswordTextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.signup_password_descrption),
            fontSize = 12.sp,
            color = AtSoptTheme.colors.textSecondary,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(Modifier.weight(1f))

        AtSoptButton(
            text = stringResource(R.string.next),
            backgroundColor = AtSoptTheme.colors.dividerPrimary,
            onClick = {
                if(isEnabled) navigateSignIn()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            isEnabled = isEnabled,
            borderColor = AtSoptTheme.colors.textPrimary
        )
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    AtSoptAndroidTheme {
        SignUpScreen(
            paddingValues = PaddingValues(),
            state = SignUpState(),
            navigateUp = {},
            navigateSignIn = {},
            onIdChange = {},
            onPasswordChange = {},
            navigatePassword = {}
        )
    }
}