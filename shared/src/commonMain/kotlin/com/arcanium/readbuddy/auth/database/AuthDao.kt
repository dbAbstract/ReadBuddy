package com.arcanium.readbuddy.auth.database

import com.arcanium.readbuddy.auth.model.User
import com.arcanium.readybuddy.db.AuthDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class AuthDao(
    databaseDriverFactory: AuthDatabaseDriverFactory
) {
    private val database = AuthDatabase(driver = databaseDriverFactory.createDriver())

    suspend fun getUserByUsername(username: String): User = withContext(Dispatchers.IO) {
        database.authEntityQueries.getUser(username = username)
            .executeAsOne()
            .toUser()
    }

    suspend fun insertUser(
        user: User,
        authContents: String
    ) = withContext(Dispatchers.IO) {
        database.authEntityQueries.insertUser(
            username = user.username,
            authContent = authContents,
            firstName = user.firstname,
            surname = user.surname
        )
    }
}