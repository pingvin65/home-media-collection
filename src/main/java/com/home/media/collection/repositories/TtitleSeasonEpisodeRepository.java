package com.home.media.collection.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.home.media.collection.models.TtitleSeasonEpisode;
import com.home.media.collection.models.TtitleSeasonEpisodeKey;

@RepositoryRestResource(collectionResourceRel = "title-season-episodes", path = "title-season-episodes")
public interface TtitleSeasonEpisodeRepository
		extends PagingAndSortingRepository<TtitleSeasonEpisode, TtitleSeasonEpisodeKey> {

}