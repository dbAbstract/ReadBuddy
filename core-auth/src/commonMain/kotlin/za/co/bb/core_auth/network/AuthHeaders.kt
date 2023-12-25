package za.co.bb.core_auth.network

object AuthHeaders {
    const val X_RAPID_API_KEY = "X-RapidAPI-Key"
    const val X_RAPID_API_HOST = "X-RapidAPI-Host"

    // TODO - Replace with blanks
    val authHeaders = mutableMapOf(
        X_RAPID_API_KEY to "4265df0558mshb6e1736dcf61352p18267cjsn10bedcf4ce3f",
        X_RAPID_API_HOST to "books-api7.p.rapidapi.com"
    )

    fun setHeader(key: String, value: String) {
        authHeaders[key] = value
    }
}