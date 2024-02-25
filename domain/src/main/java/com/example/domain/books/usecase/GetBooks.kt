package com.example.domain.books.usecase

import com.example.domain.books.repository.BooksRepository
import javax.inject.Inject

class GetBooks  @Inject constructor(private val booksRepository: BooksRepository) {
    suspend operator fun invoke(page: Int) = booksRepository.getAllBooks(page)
}