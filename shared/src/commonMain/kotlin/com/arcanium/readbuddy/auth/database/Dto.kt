package com.arcanium.readbuddy.auth.database

import com.arcanium.readbuddy.AuthEntity
import com.arcanium.readbuddy.auth.model.User

internal fun AuthEntity.toUser(): User = User(
    username = username,
    firstname = firstName,
    surname = surname
)