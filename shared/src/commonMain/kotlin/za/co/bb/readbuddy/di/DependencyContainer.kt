package za.co.bb.readbuddy.di

import za.co.bb.books_data.di.BooksDependencyContainer
import za.co.bb.books_domain.repository.BooksRepository
import za.co.bb.readbuddy.auth.AuthNetworkRepository

object DependencyContainer {
    val booksRepository: BooksRepository by lazy {
        BooksDependencyContainer.booksRepository
    }

    val authNetworkRepository: AuthNetworkRepository by lazy {
        AuthNetworkRepository()
    }
}