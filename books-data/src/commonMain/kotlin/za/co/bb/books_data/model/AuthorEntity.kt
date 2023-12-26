package za.co.bb.books_data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AuthorEntity(
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val surname: String
)
