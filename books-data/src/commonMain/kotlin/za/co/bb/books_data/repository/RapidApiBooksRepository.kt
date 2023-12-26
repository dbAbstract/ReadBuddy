package za.co.bb.books_data.repository

import za.co.bb.books_data.datasource.remote.BooksApi
import za.co.bb.books_data.datasource.remote.model.toBook
import za.co.bb.books_domain.model.Book
import za.co.bb.books_domain.repository.BooksRepository

internal class RapidApiBooksRepository(
    private val booksApi: BooksApi
) : BooksRepository {
    override suspend fun getRandomBook(): Book {
        return booksApi.getRandomBook().toBook()
    }

}