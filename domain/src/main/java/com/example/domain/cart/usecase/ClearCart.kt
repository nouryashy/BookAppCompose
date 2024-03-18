package com.example.domain.cart.usecase

import com.example.domain.cart.repository.CartRepository
import javax.inject.Inject

class ClearCart @Inject constructor(private val cartBookRepository: CartRepository) {

    suspend operator fun invoke() =
        cartBookRepository.clearCart()
}