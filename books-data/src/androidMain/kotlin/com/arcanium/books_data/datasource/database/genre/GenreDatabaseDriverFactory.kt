package com.arcanium.books_data.datasource.database.genre

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.arcanium.books_data.datasource.BooksDataContentProvider

actual class GenreDatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = TODO(),
            context = BooksDataContentProvider.applicationContext,
            name = "GenreDatabase.db"
        )
    }
}