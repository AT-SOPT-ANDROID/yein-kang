package org.sopt.at.presentation.home

data class HomeState(
    val id: String = "",
    val selectedTabIndex: Int = 0,
    val imageList: List<Int> = emptyList()
)
