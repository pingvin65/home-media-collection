package com.home.media.collection.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.home.media.collection.models.Title;
import com.home.media.collection.models.Type;
import com.home.media.collection.models.projections.TitleProjection;

@CrossOrigin
@RepositoryRestResource(excerptProjection = TitleProjection.class, exported = true)
public interface TitleRepository extends PagingAndSortingRepository<Title, Long> {

	@RestResource(path = "title-containing", rel = "title-containing")
	public Page<?> findByTitleContainingIgnoreCase(String title, Pageable pageable);

	@RestResource(path = "title", rel = "title")
	public Title findByTitleIgnoreCase(String title);

	@EntityGraph(attributePaths = { "titlesSeasons" })
	Title getByTitle(String name);

	@RestResource(path = "find-title", rel = "find-title")
	public Page<?> findByIdTitle(Long id, Pageable pageable);

	@SuppressWarnings("unchecked")
	@Override
	@RestResource(exported = false)
	public Title save(Title title);

	public Optional<?> findByTitleAndTypeAndIsSeries(String title, Type type, boolean isSeries);
}
