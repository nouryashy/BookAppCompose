package com.example.data.category.categoryBooks.remote.mapper

import com.example.data.category.categoryBooks.remote.model.CategoryBookModel
import com.example.domain.category.categorybooks.model.CategoryBook


object CategoryFormatModelMapper {
    fun mapFromEntity(entity: CategoryBookModel.FormatsCatModel): CategoryBook.FormatsCat {
        return CategoryBook.FormatsCat(
            imageJPEG = entity.imageJPEG
        )
    }

    fun mapToEntity(domain:CategoryBook.FormatsCat):  CategoryBookModel.FormatsCatModel {
        return CategoryBookModel.FormatsCatModel(
            imageJPEG = domain.imageJPEG
        )
    }
}