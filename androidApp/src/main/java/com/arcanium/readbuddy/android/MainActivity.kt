package com.arcanium.readbuddy.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.arcanium.books_data.di.BooksDependencyContainer
import com.arcanium.books_domain.model.Genre
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemedContent {
            Box(modifier = Modifier.fillMaxSize()) {

            }
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
