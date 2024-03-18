package com.example.data.category.categoryBooks.remote.model
import com.example.data.category.categoryBooks.remote.model.CategoryBookModel
import com.google.gson.annotations.SerializedName

data class CategoryBooksResponseModel(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val categoryBooks: List<CategoryBookModel>
)