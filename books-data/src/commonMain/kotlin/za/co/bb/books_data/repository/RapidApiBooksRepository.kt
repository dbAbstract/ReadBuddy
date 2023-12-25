package za.co.bb.books_data.repository

import za.co.bb.books_domain.model.Book
import za.co.bb.books_domain.repository.BooksRepository

internal class RapidApiBooksRepository : BooksRepository {
    override suspend fun getRandomBook(): Book {
        TODO("Not yet implemented")
    }

}