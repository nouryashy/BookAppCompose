package com.example.domain.books.usecase

import com.example.domain.books.repository.BooksRepository
import javax.inject.Inject

class GetTopBooks  @Inject constructor(private val booksRepository: BooksRepository) {
    suspend operator fun invoke() = booksRepository.getTopBooks()
}