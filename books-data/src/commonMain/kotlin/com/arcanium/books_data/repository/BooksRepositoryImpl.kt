package com.arcanium.books_data.repository

import com.arcanium.books_data.datasource.database.BooksDao
import com.arcanium.books_data.datasource.remote.BooksApi
import com.arcanium.books_data.datasource.remote.model.toBook
import com.arcanium.books_domain.model.Book
import com.arcanium.books_domain.model.Genre
import com.arcanium.books_domain.repository.BooksRepository
import com.russhwolf.settings.Settings
import kotlinx.datetime.LocalDateTime

internal class BooksRepositoryImpl(
    private val booksApi: BooksApi,
    private val booksDao: BooksDao,
    private val settings: Settings
) : BooksRepository {
    private var lastRefreshed: LocalDateTime? = null

    @Throws(Exception::class)
    override suspend fun getRandomBook(): Book {
        return booksApi.getRandomBook().toBook()
    }

    @Throws(Exception::class)
    override suspend fun getBookByGenres(genreList: List<Genre>): List<Book> {
        if (lastRefreshed == null) {
            val books = booksApi.getBooksByGenres(genreList = genreList).map { it.toBook() }
            booksDao.insertBooks(bookList = books)
        }

        TODO()
    }

    companion object {
        private const val LAST_REFRESHED_KEY = "lastRefreshed"
    }
}