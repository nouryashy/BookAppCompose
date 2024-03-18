package com.example.data.book.cache.mapper

import com.example.data.book.cache.entity.CachedBook
import com.example.data.book.remote.model.BookModel


object CachedBookMapper {
    fun mapFromCached(type: BookModel): CachedBook {
        val formatModel = CachedFormatMapper.mapFromCached(type.formats)


    return CachedBook(
    id = type.id,
    formats = formatModel,
    subjects = type.subjects,
    title = type.title
    )
}

fun mapToCached(entity: CachedBook): BookModel {
    val formatCashed = CachedFormatMapper.mapToCached(entity.formats)
    return BookModel(
        id = entity.id,
        formats = formatCashed,
        subjects = entity.subjects,
        title = entity.title,
    )
}
}