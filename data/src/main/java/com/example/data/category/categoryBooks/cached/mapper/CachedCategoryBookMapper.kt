package com.example.data.category.categoryBooks.cached.mapper
import com.example.data.category.categoryBooks.cached.entity.CachedCategoryBook
import com.example.data.category.categoryBooks.remote.model.CategoryBookModel

object CachedCategoryBookMapper {
    fun mapFromCached(type: CategoryBookModel): CachedCategoryBook {
        val formatModel = CachedFormatCategoryBookMapper.mapFromCached(type.formats)
        return CachedCategoryBook(
            id = type.id,
            formats = formatModel,
            subjects = type.subjects,
            title = type.title
        )
    }
    fun mapToCached(entity: CachedCategoryBook): CategoryBookModel {
        val formatCashed = CachedFormatCategoryBookMapper.mapToCached(entity.formats)
        return CategoryBookModel(
            id = entity.id,
            formats = formatCashed,
            subjects = entity.subjects,
            title = entity.title,
        )
    }
}