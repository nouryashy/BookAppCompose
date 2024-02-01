package com.example.data.books.remote.mapper
import com.example.data.books.remote.model.BookModel
import com.example.domain.books.model.Book


object BookResponseModelMapper {
    fun mapFromEntity(entity: BookModel): Book {
        val formatEntity = FormatModelMapper.mapFromEntity(entity.formats)
        return Book(
            id = entity.id,
            formats = formatEntity,
            subjects = entity.subjects,
            title = entity.title
        )
    }

    fun mapToEntity(domain: Book): BookModel {
        val formatDomain = FormatModelMapper.mapToEntity(domain.formats)
        return BookModel(
            id = domain.id,
            formats = formatDomain,
            subjects = domain.subjects,
            title = domain.title,
        )
    }
}