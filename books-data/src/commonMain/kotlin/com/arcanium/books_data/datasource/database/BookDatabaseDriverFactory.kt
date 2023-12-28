package com.arcanium.books_data.datasource.database

import app.cash.sqldelight.db.SqlDriver

expect class BookDatabaseDriverFactory() {
    fun createDriver(): SqlDriver
}