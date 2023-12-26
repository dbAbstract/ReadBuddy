package com.arcanium.books_data.repository

import com.arcanium.books_data.datasource.database.BooksDao
import com.arcanium.books_data.datasource.remote.BooksApi
import com.arcanium.books_data.datasource.remote.model.toBook
import com.arcanium.books_domain.model.Book
import com.arcanium.books_domain.repository.BooksRepository
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set

internal class BooksRepositoryImpl(
    private val booksApi: BooksApi,
    private val booksDao: BooksDao,
    private val settings: Settings
) : BooksRepository {
    override suspend fun getRandomBook(): Book {
        return booksApi.getRandomBook().toBook()
    }

}