package com.example.domain.authors.usecase


import com.example.domain.authors.repository.AuthorRepository
import javax.inject.Inject

class GetAuthors
@Inject constructor(private val authorRepository: AuthorRepository)
{
    suspend operator fun invoke() = authorRepository.getAuthors()
}