package com.example.data.category.categoryBooks.cached.mapper

import com.example.data.category.categoryBooks.cached.entity.CachedCategoryBook
import com.example.data.category.categoryBooks.remote.model.CategoryBookModel

object CachedFormatCategoryBookMapper {
    fun mapFromCached(type: CategoryBookModel.FormatsCatModel): CachedCategoryBook.CachedFormatsCat {
        return CachedCategoryBook.CachedFormatsCat(
            imageJPEG = type.imageJPEG
        )
    }
    fun mapToCached(entity: CachedCategoryBook.CachedFormatsCat): CategoryBookModel.FormatsCatModel {
        return CategoryBookModel.FormatsCatModel(
            imageJPEG = entity.imageJPEG
        )
    }
}