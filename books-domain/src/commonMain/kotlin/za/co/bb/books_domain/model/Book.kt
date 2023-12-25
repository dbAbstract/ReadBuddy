package za.co.bb.books_domain.model

data class Book(
    val id: String,
    val title: String,
    val author: Author,
    val review: Review,
    val pages: Int,
    val genres: Set<String>,
    val rating: Double,
    val plot: String,
    val url: String
)
