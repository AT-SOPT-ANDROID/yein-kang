package org.sopt.at.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.at.presentation.main.component.MainBottomBar
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.ui.theme.AtSoptTheme

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
    modifier: Modifier = Modifier
) {
    val snackBarHostState = remember { SnackbarHostState() }

    MainScreenContent(
        navigator = navigator,
        snackBarHostState = snackBarHostState,
        modifier = modifier
    )
}

@Composable
private fun MainScreenContent(
    navigator: MainNavigator,
    snackBarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .background(color = AtSoptTheme.colors.backgroundPrimary),
        content = { padding ->
            AtSoptNavHost(
                navigator = navigator,
                paddingValues = padding,
                snackBarHostState = snackBarHostState
            )
        },
        bottomBar = {
            MainBottomBar(
                modifier = Modifier
                    .background(color = AtSoptTheme.colors.backgroundPrimary)
                    .navigationBarsPadding(),
                isVisible = navigator.showBottomBar(),
                tabs = MainTabType.entries.toMutableList(),
                currentTabSelected = navigator.currentTab,
                onTabSelected = navigator::navigateTab
            )
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarHostState
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    AtSoptAndroidTheme {
        MainScreen(
            navigator = rememberMainNavigator()
        )
    }
}
