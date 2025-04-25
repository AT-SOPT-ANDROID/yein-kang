package org.sopt.at.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.entity.SignInEntity
import org.sopt.at.entity.SignUpEntity
import org.sopt.at.presentation.R
import org.sopt.at.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SignUpSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<SignUpSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun updateId(id: String) {
        _state.value = _state.value.copy(uiState = _state.value.uiState.copy(id = id))
    }

    fun updatePassword(password: String) {
        _state.value = _state.value.copy(uiState = _state.value.uiState.copy(password = password))
    }

    fun updateIdScreen() {
        val isIdMatched = idPattern.matches(_state.value.uiState.id)
        if(isIdMatched) {
            _state.value = _state.value.copy(isIdScreen = !_state.value.isIdScreen)
        } else {
            snackBar(R.string.signup_id_snackbar)
        }
    }

    fun navigateUp()  = viewModelScope.launch {
        _sideEffect.emit(SignUpSideEffect.NavigateUp)
    }

    fun navigateSignIn() = viewModelScope.launch {
        val isPasswordMatched = passwordPattern.matches(_state.value.uiState.password)
        if(isPasswordMatched) {
            saveUser()
            _sideEffect.emit(SignUpSideEffect.NavigateSignIn(_state.value.uiState.id, _state.value.uiState.password))
        }
        else {
            snackBar(R.string.signup_password_snackbar)
        }
    }

    fun snackBar(message: Int) = viewModelScope.launch {
        _sideEffect.emit(SignUpSideEffect.SnackBar(message))
    }

    fun saveUser() = viewModelScope.launch {
        userRepository.saveUser(
            SignUpEntity(
                id = _state.value.uiState.id,
                password = _state.value.uiState.password
            )
        )
    }

    companion object {
        val idPattern = "^[a-z][a-z0-9]{5,11}$".toRegex()
        val passwordPattern = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#\$%^&*])[A-Za-z\\d~!@#\$%^&*]{8,15}$".toRegex()
    }
}