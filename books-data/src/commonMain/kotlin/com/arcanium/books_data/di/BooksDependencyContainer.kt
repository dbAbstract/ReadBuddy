package com.arcanium.books_data.di

import com.arcanium.books_data.datasource.database.BookDatabaseDriverFactory
import com.arcanium.books_data.datasource.database.BooksDao
import com.arcanium.books_data.datasource.remote.BooksApi
import com.arcanium.books_data.repository.BooksRepositoryImpl
import com.arcanium.books_domain.repository.BooksRepository
import com.arcanium.readbuddy.di.DependencyContainer

object BooksDependencyContainer {
    private val bookDbDriverFactory by lazy {
        BookDatabaseDriverFactory()
    }

    private val booksApi by lazy {
        BooksApi(authNetworkRepository = DependencyContainer.authNetworkRepository)
    }

    private val booksDao by lazy {
        BooksDao(bookDatabaseDriverFactory = bookDbDriverFactory)
    }

    val booksRepository: BooksRepository by lazy {
        BooksRepositoryImpl(
            booksApi = booksApi,
            booksDao = booksDao,
            settings = DependencyContainer.settings
        )
    }
}