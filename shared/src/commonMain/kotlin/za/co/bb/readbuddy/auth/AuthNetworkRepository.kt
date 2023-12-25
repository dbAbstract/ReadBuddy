package za.co.bb.readbuddy.auth

import za.co.bb.core_auth.network.AuthHeaders

class AuthNetworkRepository {
    fun setHeader(key: String, value: String) {
        AuthHeaders.setHeader(key = key, value = value)
    }
}