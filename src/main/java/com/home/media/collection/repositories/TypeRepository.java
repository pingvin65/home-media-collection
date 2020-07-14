package com.home.media.collection.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.home.media.collection.models.projections.TypeProjections;
import com.home.media.collection.models.Type;

@RepositoryRestResource(excerptProjection = TypeProjections.class)
public interface TypeRepository extends PagingAndSortingRepository<Type, Long> {

	Optional<Type> findByTypeMedia(String typeMedia);

}