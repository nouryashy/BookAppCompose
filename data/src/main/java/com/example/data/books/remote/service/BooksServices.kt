package com.example.data.books.remote.service


import com.example.data.books.remote.model.BooksResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface BooksServices {
    @GET("books")
    suspend fun getBooks(@Query("page") page: Int)
            : BooksResponseModel


    @GET("books")
    suspend fun getTopBooks()
            : BooksResponseModel
}