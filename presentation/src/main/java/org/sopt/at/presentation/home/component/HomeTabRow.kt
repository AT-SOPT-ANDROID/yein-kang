package org.sopt.at.presentation.home.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.presentation.component.TypeTabRow
import org.sopt.at.presentation.extension.noRippleClickable
import org.sopt.at.presentation.home.HomeTabType
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.ui.theme.AtSoptTheme

@Composable
fun HomeTabRow(
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    TypeTabRow(
        tabTitles = HomeTabType.entries.map { it.titleRes }.toList(),
        selectedTabIndex = selectedTabIndex,
        modifier = modifier
    ) { index, tab ->
        Text(
            text = stringResource(tab),
            color = if (selectedTabIndex == index) AtSoptTheme.colors.textPrimary else AtSoptTheme.colors.textSecondary,
            modifier = modifier
                .wrapContentWidth()
                .padding(horizontal = 8.dp)
                .noRippleClickable(
                    onClick = { onTabClick(index) }
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeTabRowPreview() {
    AtSoptAndroidTheme {
        HomeTabRow(
            selectedTabIndex = 0,
            onTabClick = {},
            modifier = Modifier.wrapContentSize()
        )
    }
}