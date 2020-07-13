package com.home.media.collection.models.projections;

import org.springframework.data.rest.core.config.Projection;

import com.home.media.collection.models.Genre;

@Projection(name = "genre", types = { Genre.class })
public interface GenreProjections {
	String getName();

}