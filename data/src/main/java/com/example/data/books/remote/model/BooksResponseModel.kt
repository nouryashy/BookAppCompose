package com.example.data.books.remote.model

import com.example.data.books.remote.model.BookModel
import com.google.gson.annotations.SerializedName

data class BooksResponseModel(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val books: List<BookModel>
)