package com.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.core.designsystem.spacing.Spacers

private val LocalAppSpacers = staticCompositionLocalOf { Spacers() }

object AppTheme {
    val spacers: Spacers
        @Composable
        @ReadOnlyComposable
        get() = LocalAppSpacers.current
}
