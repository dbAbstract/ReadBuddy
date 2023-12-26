package com.arcanium.books_domain.repository

import com.arcanium.books_domain.model.Book

interface BooksRepository {

    @Throws(Exception::class)
    suspend fun getRandomBook(): Book
}