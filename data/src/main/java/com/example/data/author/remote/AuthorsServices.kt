package com.example.data.author.remote


import com.example.data.data.authors.remote.model.AuthorsResponseModel
import retrofit2.http.GET


interface AuthorsServices {
    @GET("books")
    suspend fun getAuthors(): AuthorsResponseModel

}