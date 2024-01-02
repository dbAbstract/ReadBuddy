package com.arcanium.books_data.datasource.database

import com.arcanium.books_domain.model.Book
import com.arcanium.books_domain.model.Genre
import com.arcanium.readbuddy.db.BooksDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

internal class BooksDao(
    bookDatabaseDriverFactory: BookDatabaseDriverFactory
) {
    private val database = BooksDatabase(driver = bookDatabaseDriverFactory.createDriver())

    suspend fun getBooksByGenre(genre: Genre): List<Book> = withContext(Dispatchers.IO) {
        database.bookEntityQueries
            .getBooksByGenre(genreName = genre.value )
            .executeAsList()
            .map { it.toBook() }
    }

    suspend fun insertBookGenre(bookId: String, genre: Genre) = withContext(Dispatchers.IO) {
        database.bookGenreLinkEntityQueries.insertBookGenreLink(
            bookId = bookId,
            genreName = genre.value
        )
    }

    suspend fun insertBook(book: Book) = withContext(Dispatchers.IO) {
        database.bookEntityQueries.insertBookEntity(
            bookId = book.id,
            title = book.title,
            pages = book.pages.toLong(),
            rating = book.rating,
            plot = book.plot,
            imageUrl = book.imageUrl,
            url = book.url,
            author = "${book.author.firstName};${book.author.surname}",
            review = "${book.review.name};${book.review.body}"
        )
    }
}