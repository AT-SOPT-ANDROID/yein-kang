package org.sopt.at.presentation.home

data class HomeState(
    val selectedTabIndex: Int = 0,
    val imageList: List<Int> = emptyList()
)

