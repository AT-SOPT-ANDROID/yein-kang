package org.sopt.at.presentation.signin

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.presentation.main.Route

fun NavController.navigateToSignIn(navOptions: NavOptions? = null) {
    navigate(
        route = Route.SignIn,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.signInNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateHome: () -> Unit,
    navigateSignUp: () -> Unit,
    snackBarHostState: SnackbarHostState
) {
    composable<Route.SignIn> {
        SignInRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
            navigateHome = navigateHome,
            navigateSignUp = navigateSignUp,
            snackBarHostState = snackBarHostState

        )
    }
}
