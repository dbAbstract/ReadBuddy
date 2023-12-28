package com.arcanium.readbuddy.auth.database

import app.cash.sqldelight.db.SqlDriver

expect class AuthDatabaseDriverFactory() {
    fun createDriver(): SqlDriver
}