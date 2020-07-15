package com.home.media.collection.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.home.media.collection.models.TitleSeason;
import com.home.media.collection.models.TitleSeasonKey;
import com.home.media.collection.models.projections.TitleSeasonProjections;

@RepositoryRestResource(excerptProjection = TitleSeasonProjections.class, exported = true, collectionResourceRel = "title-seasons", path = "title-seasons")
public interface TitleSeasonRepository extends PagingAndSortingRepository<TitleSeason, TitleSeasonKey> {

	@Override
	@Modifying
	@RestResource(exported = false)
	void deleteById(TitleSeasonKey id);

	@Override
	@RestResource(exported = false)
	void deleteAll();

	@RestResource(path = "id_title-id_season", rel = "id_title-id_season")
	Optional<TitleSeason> findByIdIdTitleAndIdIdSeason(Long idTitle, Long idSeason);

	@RestResource(path = "id_title", rel = "id_title")
	public Page<TitleSeason> findByIdIdTitle(Long idTitle, Pageable pageable);

	@RestResource(path = "id_season", rel = "id_season")
	public Page<TitleSeason> findByIdIdSeason(Long idSeason, Pageable pageable);

	public Page<TitleSeason> findAll(Pageable pageable);

	@Override
	@RestResource(exported = true)
	Optional<TitleSeason> findById(@Param("id") TitleSeasonKey id);

}
