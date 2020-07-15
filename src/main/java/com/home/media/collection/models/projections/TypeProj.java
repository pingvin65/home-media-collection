package com.home.media.collection.models.projections;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface TypeProj {
	@JsonProperty("type-media")
	String getTypeMedia();
}
