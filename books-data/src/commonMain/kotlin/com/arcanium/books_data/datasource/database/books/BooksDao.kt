package com.arcanium.books_data.datasource.database.books

import com.arcanium.books_domain.model.Book
import com.arcanium.readybuddy.db.BookEntity
import com.arcanium.readybuddy.db.books.BooksDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

internal class BooksDao(
    bookDatabaseDriverFactory: BookDatabaseDriverFactory
) {
    private val bookDatabase = BooksDatabase(driver = bookDatabaseDriverFactory.createDriver())

    suspend fun getAllBooks(): List<BookEntity> = withContext(Dispatchers.IO) {
        bookDatabase.bookQueries.getAllBookEntities().executeAsList()
    }

    suspend fun insertBooks(bookList: List<Book>) = withContext(Dispatchers.IO) {
        bookDatabase.transaction {
            bookList.forEach { book ->
                bookDatabase.bookQueries.insertBookEntity(
                    bookId = book.id,
                    title = book.title,
                    pages = book.pages.toLong(),
                    rating = book.rating,
                    plot = book.plot,
                    cover = book.imageUrl,
                    url = book.url,
                    author = "${book.author.firstName};${book.author.surname}",
                    review = "${book.review.name};${book.review.body}"
                )
            }
        }
    }
}