package com.arcanium.readbuddy.auth.repository

import com.arcanium.readbuddy.auth.database.AuthDao
import com.arcanium.readbuddy.auth.model.User

class AuthNetworkRepository(
    private val authDao: AuthDao
) {

    private var currentUser: User? = null


    // TODO - Replace with blanks
    val authHeaders = mutableMapOf(
        X_RAPID_API_KEY to "4265df0558mshb6e1736dcf61352p18267cjsn10bedcf4ce3f",
        X_RAPID_API_HOST to "books-api7.p.rapidapi.com"
    )

    fun setHeader(key: String, value: String) {
        authHeaders[key] = value
    }

    companion object {
        private const val X_RAPID_API_KEY = "X-RapidAPI-Key"
        private const val X_RAPID_API_HOST = "X-RapidAPI-Host"
    }
}