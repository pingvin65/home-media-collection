package com.home.media.collection.models.projections;

import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.home.media.collection.models.Type;

@Projection(name = "type", types = { Type.class })
public interface TypeProjections{
	@JsonProperty("type-media")
	String getTypeMedia();

}
