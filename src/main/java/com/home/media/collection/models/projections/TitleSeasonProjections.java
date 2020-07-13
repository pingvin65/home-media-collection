package com.home.media.collection.models.projections;

import org.springframework.data.rest.core.config.Projection;

import com.home.media.collection.models.TitleSeason;

@Projection(name = "title-season", types = { TitleSeason.class })
public interface TitleSeasonProjections {

	String getPicture();

	public Title getTitle();

	interface Title {
		String getTitle();
	}

	public Season getSeason();

	interface Season {
		Long getSeason();
	}

}
