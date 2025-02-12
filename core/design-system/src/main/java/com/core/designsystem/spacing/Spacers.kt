package com.core.designsystem.spacing

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacers(
    val padding: AppPadding = AppPadding(),
    val component: ComponentPadding = ComponentPadding(),
)

data class AppPadding(
    val padding2: Dp = 2.dp,
    val padding4: Dp = 4.dp,
    val padding6: Dp = 6.dp,
    val padding8: Dp = 8.dp,
    val padding10: Dp = 10.dp,
    val padding12: Dp = 12.dp,
    val padding16: Dp = 16.dp,
    val padding18: Dp = 18.dp,
    val padding20: Dp = 20.dp,
    val padding30: Dp = 30.dp,
    val padding50: Dp = 50.dp,
)

data class ComponentPadding(
    val labelStartPadding: Dp = 15.dp,
)
