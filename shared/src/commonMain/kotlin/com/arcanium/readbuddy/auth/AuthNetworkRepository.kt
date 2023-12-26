package com.arcanium.readbuddy.auth

import com.arcanium.core_auth.network.AuthHeaders

class AuthNetworkRepository {
    fun setHeader(key: String, value: String) {
        AuthHeaders.setHeader(key = key, value = value)
    }
}