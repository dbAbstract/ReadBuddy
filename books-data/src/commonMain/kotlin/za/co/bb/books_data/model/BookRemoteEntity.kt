package za.co.bb.books_data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class BookRemoteEntity(
    @SerialName("author")
    val author: AuthorRemoteEntity,
    @SerialName("review")
    val review: ReviewRemoteEntity,
    @SerialName("book_id")
    val bookId: String,
    @SerialName("title")
    val title: String,
    @SerialName("pages")
    val pages: Int,
    @SerialName("genres")
    val genres: List<String>,
    @SerialName("rating")
    val rating: Double,
    @SerialName("plot")
    val plot: String,
    @SerialName("cover")
    val cover: String,
    @SerialName("url")
    val url: String
)
