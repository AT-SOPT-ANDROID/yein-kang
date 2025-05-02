package org.sopt.at.presentation.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
fun SignInRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateHome: () -> Unit,
    navigateSignUp: () -> Unit,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val snackBarHost = remember { SnackbarHostState() }
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is SignInSideEffect.NavigateUp -> navigateUp()
                is SignInSideEffect.NavigateHome -> navigateHome()
                is SignInSideEffect.NavigateSignUp -> navigateSignUp()
                is SignInSideEffect.SnackBar -> {
                    snackBarHost.currentSnackbarData?.dismiss()
                    snackBarHost.showSnackbar(
                        message = context.getString(sideEffect.message)
                    )
                }
            }
        }
    }

    SignInScreen(
        paddingValues = paddingValues,
        state = state,
        isEnabled = state.isEnabled,
        navigateUp = viewModel::navigateUp,
        navigateSignUp = viewModel::navigateSignUp,
        navigateHome = viewModel::navigateHome,
        onIdChange = viewModel::updateId,
        onPasswordChange = viewModel::updatePassword
    )
}

@Composable
fun SignInScreen(
    paddingValues: PaddingValues,
    state: SignInState,
    isEnabled: Boolean,
    navigateUp: () -> Unit,
    navigateHome: () -> Unit,
    navigateSignUp: () -> Unit,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
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

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = stringResource(R.string.tving_login),
            modifier = Modifier.padding(horizontal = 16.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            color = AtSoptTheme.colors.textPrimary
        )

        Spacer(modifier = Modifier.height(20.dp))

        AtSoptTextField(
            value = state.uiState.id,
            onValueChange = onIdChange,
            placeholder = stringResource(R.string.id),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        AtSoptPasswordTextField(
            value = state.uiState.password,
            onValueChange = onPasswordChange,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        AtSoptButton(
            text = stringResource(R.string.login),
            backgroundColor = AtSoptTheme.colors.dividerPrimary,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            isEnabled = isEnabled,
            onClick = {
                navigateHome()
            }

        )

        Spacer(modifier = Modifier.height(36.dp))

        SignInTextButton(
            navigateSignUp = navigateSignUp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.signin_description),
            fontSize = 12.sp,
            color = AtSoptTheme.colors.dividerPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SignInTextButton(
    navigateSignUp: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
    ) {
        Text(
            text = stringResource(R.string.signin_find_id),
            fontSize = 16.sp,
            color = AtSoptTheme.colors.textSecondary,
            modifier = Modifier
                .clickable {

                }
        )

        Text(
            text = stringResource(R.string.signin_divider),
            fontSize = 16.sp,
            color = AtSoptTheme.colors.textSecondary,
            modifier = Modifier.padding(top = 2.dp)
        )

        Text(
            text = stringResource(R.string.signin_find_password),
            fontSize = 16.sp,
            color = AtSoptTheme.colors.textSecondary,
            modifier = Modifier
                .clickable {

                }
        )

        Text(
            text = stringResource(R.string.signin_divider),
            fontSize = 16.sp,
            color = AtSoptTheme.colors.textSecondary,
            modifier = Modifier.padding(top = 2.dp)
        )

        Text(
            text = stringResource(R.string.signup_text),
            fontSize = 16.sp,
            color = AtSoptTheme.colors.textSecondary,
            modifier = Modifier
                .clickable {
                    navigateSignUp()
                }
        )
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    AtSoptAndroidTheme {
        SignInScreen(
            paddingValues = PaddingValues(),
            state = SignInState(),
            isEnabled = true,
            navigateUp = {},
            navigateSignUp = {},
            navigateHome = {},
            onIdChange = {},
            onPasswordChange = {}
        )
    }
}
