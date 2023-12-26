package com.arcanium.books_data.di

import com.arcanium.books_data.datasource.database.BooksDao
import com.arcanium.books_data.datasource.database.DatabaseDriverFactory
import com.arcanium.books_data.datasource.remote.BooksApi
import com.arcanium.books_data.repository.BooksRepositoryImpl
import com.arcanium.books_domain.repository.BooksRepository
import com.russhwolf.settings.Settings

object BooksDependencyContainer {
    val booksRepository: BooksRepository by lazy {
        BooksRepositoryImpl(
            booksApi = BooksApi(),
            booksDao = BooksDao(databaseDriverFactory = DatabaseDriverFactory()),
            settings = Settings()
        )
    }
}