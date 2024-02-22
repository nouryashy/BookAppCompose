package com.example.data.books.cache.mapper

import com.example.data.books.cache.entity.CachedBook
import com.example.data.books.remote.model.BookModel


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