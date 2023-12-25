package za.co.bb.core_auth.network

object AuthHeaders {
    const val X_RAPID_API_KEY = "4265df0558mshb6e1736dcf61352p18267cjsn10bedcf4ce3f"
    const val X_RAPID_API_HOST = "books-api7.p.rapidapi.com"

    val headers = mutableMapOf(
        X_RAPID_API_KEY to "",
        X_RAPID_API_HOST to ""
    )

    fun setHeader(key: String, value: String) {
        headers[key] = value
    }
}