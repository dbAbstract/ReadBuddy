package com.arcanium.books_data.datasource.database

import com.arcanium.readybuddy.db.BookEntity
import com.arcanium.readybuddy.db.BooksDatabase

internal class BooksDao(
    databaseDriverFactory: DatabaseDriverFactory
) {
    private val database = BooksDatabase(driver = databaseDriverFactory.createDriver())

    suspend fun getAllBooks(): List<BookEntity> {
        return database.bookQueries.getAllBookEntities().executeAsList()
    }

}