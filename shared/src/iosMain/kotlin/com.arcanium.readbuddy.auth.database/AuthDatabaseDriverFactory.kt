package com.arcanium.readbuddy.auth.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.arcanium.readybuddy.db.AuthDatabase

actual class AuthDatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = AuthDatabase.Schema,
            name = "AuthDatabase.db"
        )
    }
}