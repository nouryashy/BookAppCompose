package com.example.domain.cart.usecase

import com.example.domain.cart.model.Cart
import com.example.domain.cart.repository.CartRepository
import javax.inject.Inject

class RemoveBookFromCart @Inject constructor(private val cartBookRepository: CartRepository) {
//    suspend operator fun invoke(bookId: Int, quantity: Int) =
//        cartBookRepository.removeBookFromCart(bookId = bookId, quantity = quantity)

    suspend operator fun invoke(cart: Cart) =
        cartBookRepository.removeBookFromCart(cart = cart)
}