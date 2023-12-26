package com.arcanium.books_data.di

import com.arcanium.books_data.datasource.database.books.BookDatabaseDriverFactory
import com.arcanium.books_data.datasource.database.books.BooksDao
import com.arcanium.books_data.datasource.remote.BooksApi
import com.arcanium.books_data.repository.BooksRepositoryImpl
import com.arcanium.books_domain.repository.BooksRepository
import com.arcanium.readbuddy.di.DependencyContainer

object BooksDependencyContainer {
    val booksRepository: BooksRepository by lazy {
        BooksRepositoryImpl(
            booksApi = BooksApi(authNetworkRepository = DependencyContainer.authNetworkRepository),
            booksDao = BooksDao(bookDatabaseDriverFactory = BookDatabaseDriverFactory()),
            settings = DependencyContainer.settings
        )
    }
}