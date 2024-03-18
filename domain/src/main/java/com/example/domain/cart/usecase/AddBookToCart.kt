package com.example.domain.cart.usecase

import com.example.domain.books.model.Book
import com.example.domain.cart.model.Cart
import com.example.domain.cart.repository.CartRepository
import javax.inject.Inject

class AddBookToCart @Inject constructor(private val cartBookRepository: CartRepository) {
//    suspend operator fun invoke(book: Book) =
//        cartBookRepository.addBookToCart(book = book)

    suspend operator fun invoke(cart: Cart) =
        cartBookRepository.addBookToCart(cart = cart)
}