package com.arcanium.books_data.repository

import co.touchlab.kermit.Logger
import com.arcanium.books_data.datasource.database.BooksDao
import com.arcanium.books_data.datasource.remote.BooksApi
import com.arcanium.books_data.datasource.remote.model.toBook
import com.arcanium.books_domain.model.Book
import com.arcanium.books_domain.model.Genre
import com.arcanium.books_domain.repository.BooksRepository
import com.arcanium.readbuddy.util.epochSeconds
import com.arcanium.readbuddy.util.fromEpochSeconds
import com.arcanium.readbuddy.util.now
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import io.ktor.util.Digest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.datetime.LocalDateTime

internal class BooksRepositoryImpl(
    private val booksApi: BooksApi,
    private val booksDao: BooksDao,
    private val settings: Settings
) : BooksRepository {

    private val log = Logger.withTag(tag = "BookRepo")

    @Throws(Exception::class)
    override suspend fun getRandomBook(): Book {
        return booksApi.getRandomBook().toBook()
    }

    @Throws(Exception::class)
    override suspend fun getBookByGenres(genreList: List<Genre>): Map<Genre, List<Book>> {
        if (lastRefreshed() == null) {
            log.i { "Fetching remote Books" }
            val remoteBookList = booksApi.getBooksByGenres(genreList = genreList)

            remoteBookList.forEach { bookEntity ->
                log.i { "Caching book ${bookEntity.title}" }
                val genresForBook = bookEntity.genres.mapNotNull { genreName ->
                    Genre.getGenreByString(genreName)
                }
                genresForBook.forEach { genre ->
                    booksDao.insertBookGenre(
                        bookId = bookEntity.bookId,
                        genre = genre
                    )
                }
                val book = bookEntity.toBook()
                booksDao.insertBook(book = book)
            }
            settings.set(key = LAST_REFRESHED_KEY, value = now.epochSeconds)
        } else log.i { "Fetching books from cache." }

        val bookGenreMap = mutableMapOf<Genre, List<Book>>()
        genreList.forEach { genre ->
            log.i { "Retrieving book for genre=$genre" }
            bookGenreMap[genre] = booksDao.getBooksByGenre(genre)
        }

        return bookGenreMap
    }

    private suspend fun lastRefreshed(): LocalDateTime? = withContext(Dispatchers.IO) {
        val epochSeconds = settings.get<Long>(key = LAST_REFRESHED_KEY)
        epochSeconds?.let {
            fromEpochSeconds(epochSeconds = it)
        }
    }

    companion object {
        private const val LAST_REFRESHED_KEY = "lastRefreshed"
    }
}