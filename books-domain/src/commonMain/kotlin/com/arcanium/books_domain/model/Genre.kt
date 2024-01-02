package com.arcanium.books_domain.model

enum class Genre(val value: String) {
    Fantasy(value = "fantasy"),
    TenthCentury(value = "10th-century"),
    EleventhCentury(value = "11th-century"),
    TwelfthCentury(value = "12th-century"),
    Adult(value = "adult"),
    Academia(value = "academia"),
    Africa(value = "africa"),
    Adventure(value = "adventure"),
    AdultFiction(value = "adult-fiction"),
    Art(value = "art"),
    Biography(value = "biography"),
    Business(value = "business"),
    Childrens(value = "childrens"),
    Christian(value = "christian"),
    Classics(value = "classics"),
    Comics(value = "comics"),
    Cookbooks(value = "cookbooks"),
    Ebooks(value = "ebooks"),
    Fiction(value = "fiction"),
    GraphicNovels(value = "graphic-novels"),
    HistoricalFiction(value = "historical-fiction"),
    History(value = "history"),
    Horror(value = "horror"),
    Memoir(value = "memoir"),
    Music(value = "music"),
    Mystery(value = "mystery"),
    Nonfiction(value = "nonfiction"),
    Poetry(value = "poetry"),
    Psychology(value = "psychology"),
    Romance(value = "romance"),
    Science(value = "science"),
    ScienceFiction(value = "science-fiction"),
    SelfHelp(value = "self-help"),
    Sports(value = "sports"),
    Thriller(value = "thriller"),
    Travel(value = "travel"),
    YoungAdult(value = "young-adult");

    companion object {
        fun getGenreByString(value: String): Genre? {
            return entries.find { it.value == value }
        }
    }
}