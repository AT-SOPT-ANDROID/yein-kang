package org.sopt.at.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.presentation.home.component.ContentRow
import org.sopt.at.presentation.home.component.HomeTabRow
import org.sopt.at.presentation.home.component.HomeTopBar
import org.sopt.at.presentation.home.component.HorizontalBannerPager
import org.sopt.at.presentation.home.component.RankContentRow
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.ui.theme.AtSoptTheme

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    navigateMy: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current
    val counter by remember { mutableIntStateOf(0) }
    val currentCounter by rememberUpdatedState(counter)

    LaunchedEffect(currentCounter) {
        viewModel.getUser()
        viewModel.updateImageList()
    }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is HomeSideEffect.NavigateMy -> navigateMy()
            }
        }
    }

    HomeScreen(
        paddingValues = paddingValues,
        state = state,
        onTabSelected = viewModel::updateSelectedTabIndex,
        navigateMy = viewModel::navigateMy
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    state: HomeState,
    onTabSelected: (Int) -> Unit,
    navigateMy: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = AtSoptTheme.colors.backgroundPrimary)
            .padding(bottom = paddingValues
                .calculateBottomPadding()
            )
    ) {
        item {
            HomeTopBar(
                onClickProfile = navigateMy
            )
            Spacer(Modifier.height(8.dp))
        }

        stickyHeader {
            HomeTabRow(
                selectedTabIndex = state.selectedTabIndex,
                onTabClick = onTabSelected
            )

            Spacer(Modifier.height(8.dp))
        }

        item {
            if (state.imageList.isNotEmpty()) {
                HorizontalBannerPager(
                    imageList = state.imageList
                )
            }
            Spacer(Modifier.height(8.dp))
        }

        item {
            RankContentRow(
                contentList = state.imageList
            )
            Spacer(Modifier.height(8.dp))
        }

        item {
            ContentRow(
                contentList = state.imageList
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    AtSoptAndroidTheme {
        HomeScreen(
            paddingValues = PaddingValues(0.dp),
            state = HomeState(),
            onTabSelected = {},
            navigateMy = {}
        )
    }
}
