package org.sopt.at.presentation.signin

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
import org.sopt.at.entity.SignInEntity
import org.sopt.at.presentation.R
import org.sopt.at.repository.AuthRepository
import org.sopt.at.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SignInState())
    val state: StateFlow<SignInState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SignInSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<SignInSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun updateId(id: String) {
        _state.value = _state.value.copy(uiState = _state.value.uiState.copy(id = id))
    }

    fun updatePassword(password: String) {
        _state.value = _state.value.copy(uiState = _state.value.uiState.copy(password = password))
    }

    fun navigateUp() = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.NavigateUp)
    }

    fun signIn() = viewModelScope.launch {
        val signInData = SignInEntity(
            id = _state.value.uiState.id,
            password = _state.value.uiState.password
        )
        authRepository.signIn(signInData).onSuccess {
            if (it != null) {
                userRepository.saveUser(it)
            }
            snackBar(R.string.signin_success)
            delay(1L)
            navigateHome()
        }.onFailure {
            snackBarMessage(it.message.toString())
        }
    }

    fun navigateHome() = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.NavigateHome)
    }

    fun navigateSignUp() = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.NavigateSignUp)
    }

    fun snackBar(message: Int) = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.SnackBar(message))
    }

    fun snackBarMessage(message: String) = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.SnackBarMessage(message))
    }
}
