package com.core.designsystem.component.button

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.core.designsystem.color.AppColors
import com.core.designsystem.shape.AppShapes
import com.core.designsystem.spacing.AppSpacing

@Composable
fun PrimaryButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.Primary,
            contentColor = AppColors.OnPrimary
        ),
        shape = AppShapes.Medium,
        modifier = modifier.padding(AppSpacing.Small)
    ) {
        Text(text)
    }
}
