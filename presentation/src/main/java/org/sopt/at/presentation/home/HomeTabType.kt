package org.sopt.at.presentation.home

import androidx.annotation.StringRes
import org.sopt.at.presentation.R

enum class HomeTabType(
    @StringRes val titleRes: Int
) {
    DRAMA(R.string.drama),
    VARIETY(R.string.variety),
    MOVIE(R.string.movie),
    SPORT(R.string.sport),
    ANIMATION(R.string.animation),
    NEWS(R.string.news),
    LIVE(R.string.home_live)
}
