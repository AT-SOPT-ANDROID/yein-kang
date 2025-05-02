package org.sopt.at.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import org.sopt.at.presentation.R

enum class MainTabType(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: MainTabRoute
) {
    HOME(
        title = R.string.home,
        icon = R.drawable.home,
        route = MainTabRoute.Home
    ),
    SHORTS(
        title = R.string.shorts,
        icon = R.drawable.shorts,
        route = MainTabRoute.Shorts
    ),
    LIVE(
        title = R.string.live,
        icon = R.drawable.live,
        route = MainTabRoute.Live
    ),
    SEARCH(
        title = R.string.search,
        icon = R.drawable.search,
        route = MainTabRoute.Search
    ),
    HISTORY(
        title = R.string.history,
        icon = R.drawable.history,
        route = MainTabRoute.History
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTabType? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}