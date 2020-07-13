package com.home.media.collection.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.home.media.collection.models.Genre;
import com.home.media.collection.models.projections.GenreProjections;

@RepositoryRestResource(excerptProjection = GenreProjections.class, collectionResourceRel = "genres", path = "genres")
public interface GenreRepository extends PagingAndSortingRepository<Genre, Long> {

}