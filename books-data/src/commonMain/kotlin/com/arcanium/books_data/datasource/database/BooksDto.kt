package com.arcanium.books_data.datasource.database

import com.arcanium.books_domain.model.Author
import com.arcanium.books_domain.model.Book
import com.arcanium.books_domain.model.Review
import com.arcanium.readybuddy.db.BookEntity
import com.arcanium.readybuddy.db.Genre

fun BookEntity.toBook(genreEntities: Set<Genre>): Book {
    val (firstName, surname) = author.split(";")
    val (reviewer, reviewBody) = review.split(";")

    return Book(
        id = bookId,
        title = title,
        author = Author(firstName = firstName, surname = surname),
        review = Review(name = reviewer, body = reviewBody),
        pages = pages.toInt(),
        genres = genreEntities
            .map { it.genreName }
            .toSet(),
        rating = rating,
        plot = plot,
        url = url,
        imageUrl = cover
    )
}