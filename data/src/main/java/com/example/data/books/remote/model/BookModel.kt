package com.example.data.books.remote.model
import com.google.gson.annotations.SerializedName
data class BookModel(
    val id: Int,
    val formats: FormatsModel,
    val subjects: List<String>,
    val title: String,
)
{
    data class FormatsModel (
        @SerializedName("image/jpeg")
        val imageJPEG: String,
    )
}