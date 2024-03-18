package com.example.data.author.cache.mapper

import com.example.data.data.authors.remote.model.AuthorsModel
import com.example.data.author.cache.entity.CachedAuthors


object CachedAuthorsMapper {
    fun mapFromCached(type: AuthorsModel): CachedAuthors {

        val authorCached= type.authors.map { authorModel ->
            CachedAuthors.CachedAuthor(
                id = authorModel.id,
                name = authorModel.name,
                birth_year = authorModel.birth_year,
                death_year = authorModel.death_year
            )
        }
        return CachedAuthors(
            id = type.id,
            authors = authorCached
        )
    }

    fun mapToCached(entity: CachedAuthors): AuthorsModel {

        val authorModel = entity.authors.map { author ->
            AuthorsModel.AuthorModel(
                id = author.id,
                name = author.name,
                birth_year = author.birth_year,
                death_year = author.death_year
            )
        }
        return AuthorsModel(
            id = entity.id,
            authors = authorModel
        )
    }
}