package com.arcanium.books_data.repository

import com.arcanium.books_data.datasource.remote.BooksApi
import com.arcanium.books_data.model.toBook
import com.arcanium.books_domain.model.Book
import com.arcanium.books_domain.repository.BooksRepository

internal class RapidApiBooksRepository(
    private val booksApi: BooksApi
) : BooksRepository {
    override suspend fun getRandomBook(): Book {
        return booksApi.getRandomBook().toBook()
    }

}