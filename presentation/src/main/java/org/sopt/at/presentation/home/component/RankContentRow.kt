package org.sopt.at.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.presentation.R
import org.sopt.at.presentation.extension.noRippleClickable
import org.sopt.at.presentation.ui.theme.AtSoptAndroidTheme
import org.sopt.at.presentation.ui.theme.AtSoptTheme

@Composable
fun RankContentRow(
    modifier: Modifier = Modifier,
    contentList: List<Int> = emptyList(),
    contentColor: Color = AtSoptTheme.colors.textPrimary,
    onRightArrowClick: () -> Unit = {},
    onItemClick: (Int) -> Unit = {}
) {
    Column(
        modifier = Modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.rank),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(contentList) { index, content ->
                Row(
                    modifier = Modifier
                        .width(100.dp)
                        .noRippleClickable(
                            onClick = { onItemClick(index) }
                        ),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = (index + 1).toString(),
                        color = contentColor,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )

                    Spacer(Modifier.width(4.dp))

                    Image(
                        painter = painterResource(id = content),
                        // 추후 수정 예정
                        contentDescription = "프로그램 이름",
                        modifier = modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .noRippleClickable(
                                onClick = { onItemClick(index) }
                            )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RankContentRowPreview() {
    AtSoptAndroidTheme {
        RankContentRow(
            contentList = listOf(
                R.drawable.banner_img1,
                R.drawable.banner_img2,
                R.drawable.banner_img3,
                R.drawable.banner_img4
            )
        )
    }
}
