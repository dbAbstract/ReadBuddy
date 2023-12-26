package za.co.bb.books_data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ReviewEntity(
    @SerialName("name")
    val name: String,
    @SerialName("body")
    val body: String
)