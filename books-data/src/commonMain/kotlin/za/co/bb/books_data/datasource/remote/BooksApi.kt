package za.co.bb.books_data.datasource.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import za.co.bb.books_data.model.BookRemoteEntity
import za.co.bb.core_auth.network.AuthHeaders

internal class BooksApi {

    @OptIn(ExperimentalSerializationApi::class)
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                explicitNulls = false
            })
        }
    }

    internal suspend fun getRandomBook(): BookRemoteEntity = withContext(Dispatchers.IO) {
        client.get {
            AuthHeaders.authHeaders.forEach {
                headers[it.key] = it.value
            }
            url {
                takeFrom(BASE_URL)
                path(GET_RANDOM_BOOK)
            }
        }.body<BookRemoteEntity>()
    }

    private companion object {
        const val BASE_URL = "https://books-api7.p.rapidapi.com"
        const val GET_RANDOM_BOOK = "/books/get/random"
    }
}