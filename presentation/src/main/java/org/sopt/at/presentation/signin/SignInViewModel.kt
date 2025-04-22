package org.sopt.at.presentation.signin

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
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(

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

    fun navigateUp()  = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.NavigateUp)
    }

    fun navigateMy() = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.NavigateMy(_state.value.uiState.id, _state.value.uiState.password))
    }

    fun navigateSignUp() = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.NavigateSignUp)
    }

    fun snackBar(message: Int) = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.SnackBar(message))
    }
}