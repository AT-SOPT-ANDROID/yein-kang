package org.sopt.at.presentation.my

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MyRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: MyViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getMyNickName()
    }

    MyScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp,
        state = state
    )
}

@Composable
fun MyScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    state: MyState,
    modifier: Modifier = Modifier
) {
    Text(
        text = if(state.nickName.isEmpty()) "내 닉네임을 불러오는 중입니다." else state.nickName,
        modifier = modifier
    )
}
