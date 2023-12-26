package za.co.bb.readbuddy.di

import za.co.bb.books_data.di.BooksDependencyContainer
import za.co.bb.books_domain.repository.BooksRepository

object DependencyContainer {
    val booksRepository: BooksRepository by lazy {
        BooksDependencyContainer.booksRepository
    }
}