package com.arcanium.books_domain.repository

import com.arcanium.books_domain.model.Book
import com.arcanium.books_domain.model.Genre

interface BooksRepository {
    @Throws(Exception::class)
    suspend fun getRandomBook(): Book

    @Throws(Exception::class)
    suspend fun getBookByGenres(genreList: List<Genre>): Map<Genre, List<Book>>
}