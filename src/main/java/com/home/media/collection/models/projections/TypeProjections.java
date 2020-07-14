package com.home.media.collection.models.projections;

import org.springframework.data.rest.core.config.Projection;

import com.home.media.collection.models.Type;

@Projection(name = "type", types = { Type.class })
public interface TypeProjections {
	String getTypeMedia();

}
