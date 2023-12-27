package com.arcanium.books_data.datasource.database.genre

import com.arcanium.readybuddy.db.BooksDatabase

internal class GenreDao(
    private val genreDatabaseDriverFactory: GenreDatabaseDriverFactory
) {
    private val bookDatabase = BooksDatabase(genreDatabaseDriverFactory.createDriver())

}