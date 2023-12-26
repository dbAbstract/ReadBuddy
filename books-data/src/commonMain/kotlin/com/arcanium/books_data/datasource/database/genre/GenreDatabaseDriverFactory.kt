package com.arcanium.books_data.datasource.database.genre

import app.cash.sqldelight.db.SqlDriver

expect class GenreDatabaseDriverFactory {
    fun createDriver(): SqlDriver
}