package za.co.bb.books_data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import za.co.bb.books_domain.model.Author
import za.co.bb.books_domain.model.Book
import za.co.bb.books_domain.model.Review

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

internal fun BookRemoteEntity.toBook(): Book = Book(
    id = bookId,
    title = title,
    author = Author(firstName = author.firstName, surname = author.surname),
    review = Review(name = review.name, body = review.body),
    pages = pages,
    genres = genres.toSet(),
    rating = rating,
    plot = plot,
    url = url
)