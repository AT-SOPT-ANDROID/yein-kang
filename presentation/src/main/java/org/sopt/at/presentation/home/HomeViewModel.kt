package org.sopt.at.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.at.presentation.R
import org.sopt.at.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<HomeSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<HomeSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun navigateMy() = viewModelScope.launch {
        _sideEffect.emit(HomeSideEffect.NavigateMy)
    }

    fun updateSelectedTabIndex(index: Int) = _state.update {
        it.copy(selectedTabIndex = index)
    }

    fun updateImageList() = _state.update {
        it.copy(
            imageList = listOf(
                R.drawable.banner_img1,
                R.drawable.banner_img2,
                R.drawable.banner_img3,
                R.drawable.banner_img4
            )
        )
    }
}
