package org.sopt.at.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.at.presentation.history.navigateToHistory
import org.sopt.at.presentation.home.navigateToHome
import org.sopt.at.presentation.live.navigateToLive
import org.sopt.at.presentation.my.navigateToMy
import org.sopt.at.presentation.search.navigateToSearch
import org.sopt.at.presentation.shorts.navigateToShorts
import org.sopt.at.presentation.signin.navigateToSignIn
import org.sopt.at.presentation.signup.navigateToSignUp

class MainNavigator(
    val navController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = Route.SignIn

    val currentTab: MainTabType?
        @Composable get() = MainTabType.find { tab ->
            currentDestination?.route?.startsWith(tab::class.qualifiedName ?: "") == true
        }

    fun navigateTab(tab: MainTabType) {
        val navOptions = navOptions {
            popUpTo(MainTabRoute.Home) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTabType.HOME -> navController.navigateToHome(navOptions)
            MainTabType.SHORTS -> navController.navigateToShorts(navOptions)
            MainTabType.LIVE -> navController.navigateToLive(navOptions)
            MainTabType.SEARCH -> navController.navigateToSearch(navOptions)
            MainTabType.HISTORY -> navController.navigateToHistory(navOptions)
        }
    }

    private fun navigateUp() {
        navController.navigateUp()
    }

    fun navigateToMy() {
        navController.navigateToMy()
    }

    fun navigateToSignIn() {
        navController.navigateToSignIn()
    }

    fun navigateToSignUp() {
        navController.navigateToSignUp()
    }

    fun navigateToHome() {
        navController.navigateToHome()
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination<MainTabRoute.Home>()) {
            navigateUp()
        }
    }

    private inline fun <reified T : Route> isSameCurrentDestination(): Boolean =
        navController.currentDestination?.route == T::class.qualifiedName

    @Composable
    fun showBottomBar() = MainTabType.contains {
        currentDestination?.route == it::class.qualifiedName /*|| (currentDestination?.route?.startsWith(
            MainTabRoute.Map::class.qualifiedName ?: ""
        ) == true)*/
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}