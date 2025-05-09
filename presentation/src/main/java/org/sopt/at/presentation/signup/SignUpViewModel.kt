package org.sopt.at.presentation.signup

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.entity.SignUpEntity
import org.sopt.at.presentation.R
import org.sopt.at.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SignUpSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<SignUpSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun signUp() = viewModelScope.launch {
        val signUpData = SignUpEntity(
            loginId = _state.value.uiState.loginId,
            password = _state.value.uiState.password,
            nickname = _state.value.uiState.nickname
        )
        authRepository.signUp(signUpData).onSuccess {
            snackBar(R.string.signup_success)
            delay(500L)
            navigateSignIn()
        }.onFailure {
            snackBarMessage(it.message.toString())
            delay(500L)
            navigateId()
        }
    }

    fun updateId(id: String) {
        _state.value = _state.value.copy(uiState = _state.value.uiState.copy(loginId = id))
    }

    fun updatePassword(password: String) {
        _state.value = _state.value.copy(uiState = _state.value.uiState.copy(password = password))
    }

    fun updateNickname(nickname: String) {
        _state.value = _state.value.copy(uiState = _state.value.uiState.copy(nickname = nickname))
    }

    fun updateIdScreen() {
        _state.value = _state.value.copy(screenType = ScreenType.PASSWORD)
    }

    fun updatePasswordScreen() {
        _state.value = _state.value.copy(screenType = ScreenType.NICKNAME)
    }

    fun navigateUp() = viewModelScope.launch {
        _sideEffect.emit(SignUpSideEffect.NavigateUp)
    }

    fun navigateSignIn() = viewModelScope.launch {
        _sideEffect.emit(SignUpSideEffect.NavigateSignIn)
    }

    fun navigateId() = viewModelScope.launch {
        _state.value = _state.value.copy(screenType = ScreenType.ID)
    }

    fun snackBarMessage(message: String) = viewModelScope.launch {
        _sideEffect.emit(SignUpSideEffect.SnackBarMessage(message))
    }

    fun snackBar(@StringRes message: Int) = viewModelScope.launch {
        _sideEffect.emit(SignUpSideEffect.SnackBar(message))
    }
}
