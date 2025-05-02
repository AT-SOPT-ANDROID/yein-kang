package org.sopt.at.presentation.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchRoute(
    paddingValues: PaddingValues,
) {
    SearchScreen(
        paddingValues = paddingValues,
    )
}

@Composable
fun SearchScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Search",
        modifier = modifier
    )
}
