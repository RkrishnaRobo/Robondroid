package com.core.designsystem.shape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

object AppShapes {
    val Small = RoundedCornerShape(4.dp)
    val Medium = RoundedCornerShape(8.dp)
    val Large = RoundedCornerShape(16.dp)
}

val AppShapesMaterial = Shapes(
    small = AppShapes.Small,
    medium = AppShapes.Medium,
    large = AppShapes.Large
)
