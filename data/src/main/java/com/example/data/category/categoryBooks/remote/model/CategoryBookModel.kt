package com.example.data.category.categoryBooks.remote.model
import com.google.gson.annotations.SerializedName


data class CategoryBookModel(
    val id: Int,
    val formats: FormatsCatModel,
    val subjects: List<String>,
    val title: String,

    )
{
    data class FormatsCatModel (
        @SerializedName("image/jpeg")
        val imageJPEG: String,
    )
}