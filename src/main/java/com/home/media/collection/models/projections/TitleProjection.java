package com.home.media.collection.models.projections;

import java.util.Date;
import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.home.media.collection.models.Genre;
import com.home.media.collection.models.Title;

@Projection(name = "t", types = { Title.class })
public interface TitleProjection {

	public String getTitle();

	public String getPath();

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	public Date getCreateDate();

	interface Type {
		@JsonProperty("type-media")

		String getTypeMedia();

	}
	public Type getType();

	public Set<Genre> getGenres();
}
