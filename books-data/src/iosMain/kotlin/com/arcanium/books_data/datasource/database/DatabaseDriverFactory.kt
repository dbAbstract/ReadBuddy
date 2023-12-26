package com.arcanium.books_data.datasource.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.arcanium.readybuddy.db.BooksDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = BooksDatabase.Schema,
            name = "BooksDatabase.db"
        )
    }
}