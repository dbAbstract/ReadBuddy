package com.arcanium.books_data.datasource.database.books

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.arcanium.books_data.datasource.BooksDataContentProvider
import com.arcanium.readybuddy.db.BooksDatabase

actual class BookDatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = BooksDatabase.Schema,
            context = BooksDataContentProvider.applicationContext,
            name = "BooksDatabase.db"
        )
    }
}