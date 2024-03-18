package com.example.domain.authors.repository

import com.example.domain.authors.model.Authors

interface AuthorRepository {
    suspend fun getAuthors(): List<Authors>


}