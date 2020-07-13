package com.home.media.collection.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Episode {
	@Id
	@Column(name = "id_episode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEpisode;

	@Column(columnDefinition = "integer default 0")
	@Max(value = 2000)
	@Min(value = 0)
	private Long episode;

	public Episode() {
		super();
	}

	public Episode(@Max(2000) @Min(0) Long episode) {
		super();
		this.episode = episode;
	}

	public Long getIdEpisode() {
		return idEpisode;
	}

	public void setIdEpisode(Long idEpisode) {
		this.idEpisode = idEpisode;
	}

	public Long getEpisode() {
		return episode;
	}

	public void setEpisode(Long episode) {
		this.episode = episode;
	}
}
