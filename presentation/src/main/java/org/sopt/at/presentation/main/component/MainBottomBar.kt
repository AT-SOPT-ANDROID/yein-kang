package org.sopt.at.presentation.main.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.presentation.extension.noRippleClickable
import org.sopt.at.presentation.main.MainTabType
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.ui.theme.AtSoptTheme

@Composable
fun MainBottomBar(
    isVisible: Boolean,
    tabs: List<MainTabType>,
    currentTabSelected: MainTabType?,
    onTabSelected: (MainTabType) -> Unit,
    modifier: Modifier = Modifier,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = EnterTransition.None + fadeIn(),
        exit = ExitTransition.None + fadeOut()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = AtSoptTheme.colors.backgroundPrimary),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            tabs.forEach { tabItem ->
                MainBottomBarItem(
                    isSelected = currentTabSelected == tabItem,
                    tabType = tabItem,
                    onTabSelected = onTabSelected,
                    tabIcon = tabItem.icon,
                    tabTitle = tabItem.title,
                )
            }
        }
    }
}

@Composable
private fun MainBottomBarItem(
    isSelected: Boolean,
    tabType: MainTabType,
    onTabSelected: (MainTabType) -> Unit,
    @DrawableRes tabIcon: Int,
    @StringRes tabTitle: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(top = 12.dp, bottom = 10.dp)
            .width((LocalConfiguration.current.screenWidthDp * 0.133).dp)
            .noRippleClickable (
                onClick = { onTabSelected(tabType) }
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = tabIcon),
            contentDescription = stringResource(id = tabTitle),
            tint = if (isSelected) {
                AtSoptTheme.colors.textPrimary
            } else {
                AtSoptTheme.colors.textSecondary
            },
        )

        Text(
            text = stringResource(tabTitle),
            color = if (isSelected) {
                AtSoptTheme.colors.textPrimary
            } else {
                AtSoptTheme.colors.textSecondary
            },
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainBottomBarPreview() {
    AtSoptAndroidTheme {
        MainBottomBar(
            isVisible = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(AtSoptTheme.colors.backgroundPrimary)
                .padding(vertical = 12.dp),
            tabs = MainTabType.entries,
            currentTabSelected = MainTabType.HOME,
            onTabSelected = {},
        )
    }
}