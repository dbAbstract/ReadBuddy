package za.co.bb.books_data.di

import za.co.bb.books_data.datasource.BooksApi
import za.co.bb.books_data.repository.RapidApiBooksRepository
import za.co.bb.books_domain.repository.BooksRepository

object BooksDependencyContainer {
    val booksRepository: BooksRepository by lazy {
        RapidApiBooksRepository(
            booksApi = BooksApi()
        )
    }
}