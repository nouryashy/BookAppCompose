package com.example.data.book.cache.mapper

import com.example.data.book.cache.entity.CachedBook
import com.example.data.book.remote.model.BookModel


object CachedFormatMapper {
    fun mapFromCached(type: BookModel.FormatsModel): CachedBook.CachedFormats {
        return CachedBook.CachedFormats(
            imageJPEG = type.imageJPEG
        )
    }

    fun mapToCached(entity: CachedBook.CachedFormats): BookModel.FormatsModel {
        return BookModel.FormatsModel(
            imageJPEG = entity.imageJPEG
        )
    }
}