package com.example.data.data.books.cache.mapper

import com.example.data.data.books.cache.entity.CachedBook
import com.example.data.data.books.remote.model.BookModel

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