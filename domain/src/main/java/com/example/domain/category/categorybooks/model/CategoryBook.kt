package com.example.domain.category.categorybooks.model
data class CategoryBook(
    val id: Int,
    val formats: FormatsCat,
    val subjects: List<String>,
    val title: String,

    )
{
    data class FormatsCat (
        val imageJPEG: String,
    )
}