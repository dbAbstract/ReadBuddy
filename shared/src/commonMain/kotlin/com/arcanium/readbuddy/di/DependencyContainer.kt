package com.arcanium.readbuddy.di

import com.arcanium.readbuddy.auth.database.AuthDao
import com.arcanium.readbuddy.auth.database.AuthDatabaseDriverFactory
import com.arcanium.readbuddy.auth.repository.AuthNetworkRepository
import com.russhwolf.settings.Settings

object DependencyContainer {
    private val authDao by lazy {
        AuthDao(databaseDriverFactory = AuthDatabaseDriverFactory())
    }

    val authNetworkRepository by lazy {
        AuthNetworkRepository(authDao = authDao)
    }

    val settings by lazy {
        Settings()
    }
}