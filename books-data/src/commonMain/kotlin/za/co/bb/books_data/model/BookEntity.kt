package za.co.bb.books_data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import za.co.bb.books_domain.model.Author
import za.co.bb.books_domain.model.Book
import za.co.bb.books_domain.model.Review

@Serializable
internal data class BookEntity(
    @SerialName("author")
    val author: AuthorEntity,
    @SerialName("review")
    val review: ReviewEntity,
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

internal fun BookEntity.toBook(): Book = Book(
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