package com.example.domain.books.model

data class Book(
    val id: Int,
    val formats: Formats,
    val subjects: List<String>,
    val title: String,

    )
{
    data class Formats (
        val imageJPEG: String,
    )
}