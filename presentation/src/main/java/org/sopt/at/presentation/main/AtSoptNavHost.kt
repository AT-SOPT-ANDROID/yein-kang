package org.sopt.at.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import org.sopt.at.presentation.history.historyNavGraph
import org.sopt.at.presentation.home.homeNavGraph
import org.sopt.at.presentation.live.liveNavGraph
import org.sopt.at.presentation.my.myNavGraph
import org.sopt.at.presentation.search.searchNavGraph
import org.sopt.at.presentation.shorts.shortsNavGraph
import org.sopt.at.presentation.signin.signInNavGraph
import org.sopt.at.presentation.signup.signUpNavGraph

@Composable
fun AtSoptNavHost(
    navigator: MainNavigator,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navigator.navController,
        startDestination = navigator.startDestination,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
    ) {
        homeNavGraph(
            paddingValues = paddingValues
        )
        shortsNavGraph(
            paddingValues = paddingValues
        )
        liveNavGraph(
            paddingValues = paddingValues
        )
        searchNavGraph(
            paddingValues = paddingValues
        )
        historyNavGraph(
            paddingValues = paddingValues
        )
        myNavGraph(
            paddingValues = paddingValues,
            navigateUp = navigator::popBackStackIfNotHome
        )
        signInNavGraph(
            paddingValues = paddingValues,
            navigateUp = navigator::popBackStackIfNotHome,
            navigateHome = navigator::navigateToHome,
            navigateSignUp = navigator::navigateToSignUp
        )
        signUpNavGraph(
            paddingValues = paddingValues,
            navigateUp = navigator::popBackStackIfNotHome,
            navigateSignIn = navigator::navigateToSignIn
        )
    }
}