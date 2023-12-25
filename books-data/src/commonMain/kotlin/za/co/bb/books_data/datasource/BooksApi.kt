package za.co.bb.books_data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import za.co.bb.books_data.model.BookRemoteEntity

internal class BooksApi {
    private val client = HttpClient(CIO)

    internal suspend fun getRandomBook(): BookRemoteEntity {
        return client.get {
        }.body<BookRemoteEntity>()
    }

    private companion object {
        const val BASE_URL = "https://books-api7.p.rapidapi.com/books/"
        const val GET_RANDOM_BOOK = ""
    }
}