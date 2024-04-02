package com.example.bookappcompose.di

import com.example.data.category.categorylabel.repository.CategoryLabelRepositoryImp
import com.example.domain.category.categorylabel.repository.CategoryLabelRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CategoryLabelRepositoryModule {
    @Provides
    fun provideCategoryRepository(): CategoryLabelRepository { return CategoryLabelRepositoryImp() }
}