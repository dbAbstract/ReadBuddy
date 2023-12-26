package com.arcanium.readbuddy.di

import com.arcanium.readbuddy.auth.AuthNetworkRepository
import com.russhwolf.settings.Settings

object DependencyContainer {
    val authNetworkRepository by lazy {
        AuthNetworkRepository()
    }

    val settings by lazy {
        Settings()
    }
}