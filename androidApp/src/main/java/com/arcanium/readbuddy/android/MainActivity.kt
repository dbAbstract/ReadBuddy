package com.arcanium.readbuddy.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemedContent {

        }
    }
}

private fun ComponentActivity.setThemedContent(
    content: @Composable () -> Unit
) {
    setContent {
        MyApplicationTheme {
            content()
        }
    }
}
