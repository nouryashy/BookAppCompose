package com.example.data.book.remote.service


import com.example.data.book.remote.model.BooksResponseModel
import retrofit2.http.GET
import retrofit2.http.Query


interface BooksServices {
    @GET("books")
    suspend fun getBooks(@Query("page") page: Int)
            : BooksResponseModel


    @GET("books")
    suspend fun getTopBooks()
            : BooksResponseModel
}