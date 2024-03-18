package com.example.data.category.categoryBooks.remote.services

import com.example.data.category.categoryBooks.remote.model.CategoryBooksResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryBooksServices {
    @GET("books")
    suspend fun getCategoryBooks(@Query("topic") topic: String)
            : CategoryBooksResponseModel
}