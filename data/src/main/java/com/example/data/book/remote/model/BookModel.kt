package com.example.data.book.remote.model
import com.google.gson.annotations.SerializedName


data class BookModel(
    val id: Int,
    val formats: FormatsModel,
    val subjects: List<String>,
    val title: String,
    val isFavorite: Boolean
)
{
    data class FormatsModel (
        @SerializedName("image/jpeg")
        val imageJPEG: String,
    )
}