package com.example.domain.books.usecase

import com.example.domain.books.model.Book
import com.example.domain.books.repository.BooksRepository
import javax.inject.Inject

class RemoveFromFavorite @Inject constructor(private val booksRepository: BooksRepository) {

    suspend operator fun invoke(book: Book) =
        booksRepository.removeFavorite(book)

}
