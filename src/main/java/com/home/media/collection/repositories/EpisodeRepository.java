package com.home.media.collection.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.home.media.collection.models.Episode;

@RepositoryRestResource()
public interface EpisodeRepository extends PagingAndSortingRepository<Episode, Long> {

}
