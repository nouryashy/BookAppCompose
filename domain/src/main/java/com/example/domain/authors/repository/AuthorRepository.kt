package com.example.domain.authors.repository

import com.example.domain.authors.model.Authors
import kotlinx.coroutines.flow.Flow

interface AuthorRepository {
    suspend fun getAuthors(): List<Authors>


}