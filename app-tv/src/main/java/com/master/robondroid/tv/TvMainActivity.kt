package com.master.robondroid.tv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.tv.material3.Text
import com.core.designsystem.component.button.PrimaryButton
import com.core.designsystem.theme.AppTheme
import com.core.designsystem.theme.RobondroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobondroidTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Hello TV", style = MaterialTheme.typography.bodyLarge)
                    Spacer(Modifier.height(AppTheme.spacers.padding.padding8))
                    PrimaryButton(text = "DesignSystemButton", onClick = {})
                }
            }
        }
    }
}
