package org.sopt.at.presentation.signin

import org.sopt.at.entity.SignInEntity

data class SignInState(
    val uiState: SignInEntity = SignInEntity(),
) {
    val isEnabled: Boolean =
        uiState.id.isNotBlank() && uiState.password.isNotBlank()
}
