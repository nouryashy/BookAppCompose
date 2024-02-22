package com.example.data.authors.data.store

import com.example.data.authors.remote.AuthorsServices
import com.example.data.data.authors.remote.model.AuthorsResponseModel

class AuthorNetworkDataSource(val apiServices: AuthorsServices) {
    suspend fun getAuthorsFromApi(): AuthorsResponseModel = apiServices.getAuthors()
}
