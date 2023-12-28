package com.arcanium.readbuddy.auth.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.arcanium.readbuddy.SharedContentProvider
import com.arcanium.readybuddy.db.AuthDatabase

actual class AuthDatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = AuthDatabase.Schema,
            context = SharedContentProvider.applicationContext,
            name = "AuthDatabase.db"
        )
    }
}