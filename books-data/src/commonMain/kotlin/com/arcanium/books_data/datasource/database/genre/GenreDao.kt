package com.arcanium.books_data.datasource.database.genre

import com.arcanium.books_data.datasource.database.genre.GenreDatabaseDriverFactory
import com.arcanium.readybuddy.db.BooksDatabase

internal class GenreDao(
    private val genreDatabaseDriverFactory: GenreDatabaseDriverFactory
) {
    private val genreDatabase = BooksDatabase(genreDatabaseDriverFactory.createDriver())

    fun getGenre() {
//        genreDatabase.
    }
}