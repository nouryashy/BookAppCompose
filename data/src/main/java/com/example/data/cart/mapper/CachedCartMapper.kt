package com.example.data.cart.mapper

import com.example.data.book.cache.entity.CachedBook
import com.example.data.book.cache.mapper.CachedCartFormatMapper
import com.example.data.book.remote.model.BookModel
import com.example.data.cart.CashedCart
import com.example.domain.cart.model.Cart


object CachedCartMapper {
    fun mapFromCached(type: Cart): CashedCart {
//        val formatModel = CachedCartFormatMapper.mapFromCached(type.formats)

        return CashedCart(
            id = type.id,
            imageUrl = type.imageUrl,
            title = type.title,
            quantity = type.quantity

        )
    }

    fun mapToCached(entity: CashedCart): Cart {
//        val formatCashed = CachedCartFormatMapper.mapToCached(entity.formats)
        return Cart(
            id = entity.id,
            imageUrl = entity.imageUrl,
            title = entity.title,
            quantity = entity.quantity
        )
    }
}