package za.co.bb.books_domain.repository

import za.co.bb.books_domain.model.Book

interface BooksRepository {

    @Throws(Exception::class)
    suspend fun getRandomBook(): Book
}