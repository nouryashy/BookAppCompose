package com.example.data.category.categoryBooks.remote.mapper

import com.example.data.category.categoryBooks.remote.model.CategoryBookModel
import com.example.domain.category.categorybooks.model.CategoryBook


object CategoryBookResponseModelMapper {
    fun mapFromEntity(entity: CategoryBookModel): CategoryBook {
        val formatEntity = CategoryFormatModelMapper.mapFromEntity(entity.formats)
        return CategoryBook(
            id = entity.id,
            formats = formatEntity,
            subjects = entity.subjects,
            title = entity.title
        )
    }

    fun mapToEntity(domain: CategoryBook): CategoryBookModel {
        val formatDomain = CategoryFormatModelMapper.mapToEntity(domain.formats)
        return CategoryBookModel(
            id = domain.id,
            formats = formatDomain,
            subjects = domain.subjects,
            title = domain.title,
        )
    }
}