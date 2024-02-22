package com.example.data.authors.remote.mapper

import com.example.data.data.authors.remote.model.AuthorsModel
import com.example.domain.authors.model.Authors

object AuthorsResponseModelMapper {

    fun mapFromEntity(entity: AuthorsModel): Authors {
        val authorEntities = entity.authors.map { authorModel ->
            Authors.Author(
                id = authorModel.id,
                name = authorModel.name,
                birth_year = authorModel.birth_year,
                death_year = authorModel.death_year
            )
        }
        return Authors(
            id = entity.id,
            authors = authorEntities
        )
    }

    fun mapToEntity(domain: Authors): AuthorsModel {
        val authorModel = domain.authors.map { author ->
            AuthorsModel.AuthorModel(
                id = author.id,
                name = author.name,
                birth_year = author.birth_year,
                death_year = author.death_year
            )
        }
        return AuthorsModel(
            id = domain.id,
            authors = authorModel
        )
    }

}