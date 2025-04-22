package org.sopt.at.presentation.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

// Background Colors
val BackgroundPrimary = Color(0xFF000000) // 전체 배경색
val BackgroundSecondary = Color(0xFF1A1A1A) // 입력 필드 배경색 (활성화 상태)
val BackgroundTertiary = Color(0xFF323232) // 입력 필드 배경색 (비활성화 상태)

// Text Colors
val TextPrimary = Color(0xFFFFFFFF) // 주요 텍스트 색상
val TextSecondary = Color(0xFF858585) // 하단 설명 텍스트 및 부가 텍스트 색상

// Divider Colors
val DividerPrimary = Color(0xFF696969) // 구분선 색상

// Accent Colors
val AccentRed = Color(0xFFFF143C) // 버튼 강조 색상

@Stable
class AtSoptColors(
    backgroundPrimary: Color,
    backgroundSecondary: Color,
    backgroundTertiary: Color,
    textPrimary: Color,
    textSecondary: Color,
    dividerPrimary: Color,
    accentRed: Color
) {
    var backgroundPrimary: Color by mutableStateOf(backgroundPrimary)
        private set
    var backgroundSecondary: Color by mutableStateOf(backgroundSecondary)
        private set
    var backgroundTertiary: Color by mutableStateOf(backgroundTertiary)
        private set
    var textPrimary: Color by mutableStateOf(textPrimary)
        private set
    var textSecondary: Color by mutableStateOf(textSecondary)
        private set
    var dividerPrimary: Color by mutableStateOf(dividerPrimary)
        private set
    var accentRed: Color by mutableStateOf(accentRed)
        private set

    fun copy(
        backgroundPrimary: Color = this.backgroundPrimary,
        backgroundSecondary: Color = this.backgroundSecondary,
        backgroundTertiary: Color = this.backgroundTertiary,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        dividerPrimary: Color = this.dividerPrimary,
        accentRed: Color = this.accentRed
    ): AtSoptColors = AtSoptColors(
        backgroundPrimary,
        backgroundSecondary,
        backgroundTertiary,
        textPrimary,
        textSecondary,
        dividerPrimary,
        accentRed
    )

    fun update(other: AtSoptColors) {
        backgroundPrimary = other.backgroundPrimary
        backgroundSecondary = other.backgroundSecondary
        backgroundTertiary = other.backgroundTertiary
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        dividerPrimary = other.dividerPrimary
        accentRed = other.accentRed
    }
}

fun atSoptColors(
    backgroundPrimary: Color = BackgroundPrimary,
    backgroundSecondary: Color = BackgroundSecondary,
    backgroundTertiary: Color = BackgroundTertiary,
    textPrimary: Color = TextPrimary,
    textSecondary: Color = TextSecondary,
    dividerPrimary: Color = DividerPrimary,
    accentRed: Color = AccentRed
) = AtSoptColors(
    backgroundPrimary = backgroundPrimary,
    backgroundSecondary = backgroundSecondary,
    backgroundTertiary = backgroundTertiary,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    dividerPrimary = dividerPrimary,
    accentRed = accentRed
)
