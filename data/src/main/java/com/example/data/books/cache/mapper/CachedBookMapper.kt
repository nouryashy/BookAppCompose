package com.example.data.books.cache.mapper

import com.example.data.books.cache.entity.CachedBook
import com.example.data.books.remote.model.BookModel
import com.example.data.data.books.cache.mapper.CachedFormatMapper


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