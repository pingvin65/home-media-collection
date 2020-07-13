package com.home.media.collection.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TtitleSeasonEpisodeKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3072929105347485251L;

	@Column(name = "id_title")
	Long idTitle;

	@Column(name = "id_season")
	Long idSeason;

	@Column(name = "id_episode")
	Long idEpisode;

	protected TtitleSeasonEpisodeKey() {

	}

	public TtitleSeasonEpisodeKey(Long idTitle, Long idSeason, Long idEpisode) {
		this.idTitle = idTitle;
		this.idSeason = idSeason;
		this.idEpisode = idEpisode;
	}

	public TtitleSeasonEpisodeKey(String idKey) {
		String[] data = idKey.split("_");
		System.out.println(data.toString());
		this.idTitle = Long.valueOf(data[0]);
		this.idSeason = Long.valueOf(data[1]);
		this.idEpisode = Long.valueOf(data[2]);
	}

	public Long getIdTitle() {
		return idTitle;
	}

	public void setIdTitle(Long idTitle) {
		this.idTitle = idTitle;
	}

	public Long getIdSeason() {
		return idSeason;
	}

	public void setIdSeason(Long idSeason) {
		this.idSeason = idSeason;
	}

	public Long getIdEpisode() {
		return idEpisode;
	}

	public void setIdEpisode(Long idEpisode) {
		this.idEpisode = idEpisode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEpisode == null) ? 0 : idEpisode.hashCode());
		result = prime * result + ((idSeason == null) ? 0 : idSeason.hashCode());
		result = prime * result + ((idTitle == null) ? 0 : idTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TtitleSeasonEpisodeKey other = (TtitleSeasonEpisodeKey) obj;
		if (idEpisode == null) {
			if (other.idEpisode != null)
				return false;
		} else if (!idEpisode.equals(other.idEpisode))
			return false;
		if (idSeason == null) {
			if (other.idSeason != null)
				return false;
		} else if (!idSeason.equals(other.idSeason))
			return false;
		if (idTitle == null) {
			if (other.idTitle != null)
				return false;
		} else if (!idTitle.equals(other.idTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(this.idTitle + "_" + this.idSeason + "_" + this.idEpisode);
	}

}
