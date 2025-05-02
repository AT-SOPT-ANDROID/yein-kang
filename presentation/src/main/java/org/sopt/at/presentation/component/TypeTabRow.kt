package org.sopt.at.presentation.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.presentation.extension.noRippleClickable
import org.sopt.at.presentation.home.HomeTabType
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.ui.theme.AtSoptTheme

@Composable
fun TypeTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabTitles: List<Int> = emptyList(),
    containerColor: Color = AtSoptTheme.colors.backgroundPrimary,
    indicator: @Composable (List<TabPosition>) -> Unit = {},
    content: @Composable RowScope.(Int, Int) -> Unit = { _, _ -> }
) {
    val scrollState = rememberScrollState()

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        indicator = indicator,
        divider = {}
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(horizontal = 16.dp)
        ) {
            tabTitles.forEachIndexed { index, title ->
                content(index, title)
            }
        }

    }
}

@Preview
@Composable
private fun TypeTabRowPreview() {
    AtSoptAndroidTheme {
        TypeTabRow(
            tabTitles = HomeTabType.entries.map { it.titleRes }.toList(),
            selectedTabIndex = 0,
        ) { index, tab ->
            Text(
                text = stringResource(tab),
                color = if (0 == index) AtSoptTheme.colors.textPrimary
                else AtSoptTheme.colors.textSecondary,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(horizontal = 8.dp)
                    .noRippleClickable(
                        onClick = { }
                    )
            )
        }
    }
}
