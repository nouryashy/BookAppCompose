package com.example.data.author.data.store

import com.example.data.author.remote.AuthorsServices
import com.example.data.data.authors.remote.model.AuthorsResponseModel

class AuthorNetworkDataSource(val apiServices: AuthorsServices) {
    suspend fun getAuthorsFromApi(): AuthorsResponseModel = apiServices.getAuthors()
}
