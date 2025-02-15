package com.master.robondroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.core.designsystem.theme.RobondroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MobileMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobondroidTheme {
                RobondroidApp()
            }
        }
    }
}
