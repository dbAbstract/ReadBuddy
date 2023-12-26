package com.arcanium.books_data.datasource.remote

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
import com.arcanium.books_data.datasource.remote.model.BookRemoteEntity
import com.arcanium.books_domain.model.Genre
import com.arcanium.core_auth.network.AuthHeaders
import io.ktor.client.request.HttpRequestBuilder

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
            attachAuthHeaders()
            url {
                takeFrom(BASE_URL)
                path(GET_RANDOM_BOOK)
            }
        }.body<BookRemoteEntity>()
    }

    internal suspend fun getBooksByGenres(genreList: List<Genre>): List<BookRemoteEntity> = withContext(Dispatchers.IO) {
        client.get {
            attachAuthHeaders()
            url {
                takeFrom(BASE_URL)
                path(GET_BOOK_BY_GENRE)
                genreList.forEach {
                    parameters.set(name = PARAMETER_GENRES, value = it.name)
                }
            }
        }.body<List<BookRemoteEntity>>()
    }

    private companion object {
        const val BASE_URL = "https://books-api7.p.rapidapi.com"
        const val GET_RANDOM_BOOK = "/books/get/random"
        const val GET_BOOK_BY_GENRE = "books/find/genres"
        const val PARAMETER_GENRES = "genres"
    }
}

private fun HttpRequestBuilder.attachAuthHeaders() {
    AuthHeaders.authHeaders.forEach {
        headers[it.key] = it.value
    }
}