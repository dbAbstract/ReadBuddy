package com.arcanium.readbuddy.di

import com.arcanium.books_data.di.BooksDependencyContainer
import com.arcanium.books_domain.repository.BooksRepository
import com.arcanium.readbuddy.auth.AuthNetworkRepository

object DependencyContainer {
    val booksRepository: BooksRepository by lazy {
        BooksDependencyContainer.booksRepository
    }

    val authNetworkRepository: AuthNetworkRepository by lazy {
        AuthNetworkRepository()
    }
}