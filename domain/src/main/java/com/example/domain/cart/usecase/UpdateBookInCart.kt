package com.example.domain.cart.usecase

import com.example.domain.cart.model.Cart
import com.example.domain.cart.repository.CartRepository
import javax.inject.Inject

class UpdateBookInCart @Inject constructor(private val cartBookRepository: CartRepository) {

    suspend operator fun invoke(cart: Cart) =
        cartBookRepository.updateBookInCart(cart)
}