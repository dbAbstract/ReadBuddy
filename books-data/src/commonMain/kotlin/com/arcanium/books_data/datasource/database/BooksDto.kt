package com.arcanium.books_data.datasource.database

import com.arcanium.books_domain.model.Author
import com.arcanium.books_domain.model.Book
import com.arcanium.books_domain.model.Review
import com.arcanium.readbuddy.db.BookEntity

fun BookEntity.toBook(): Book {
    val (firstName, surname) = author.split(";")
    val (reviewer, reviewBody) = review.split(";")

    return Book(
        id = bookId,
        title = title,
        author = Author(firstName = firstName, surname = surname),
        review = Review(name = reviewer, body = reviewBody),
        pages = pages.toInt(),
        rating = rating,
        plot = plot,
        url = url,
        imageUrl = imageUrl
    )
}