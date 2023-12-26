package com.arcanium.books_data.di

import com.arcanium.books_data.datasource.remote.BooksApi
import com.arcanium.books_data.repository.RapidApiBooksRepository
import com.arcanium.books_domain.repository.BooksRepository

object BooksDependencyContainer {
    val booksRepository: BooksRepository by lazy {
        RapidApiBooksRepository(
            booksApi = BooksApi()
        )
    }
}