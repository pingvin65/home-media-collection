package com.home.media.collection.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class TitleSeasonKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2187737999072879308L;

	@Column(name = "id_title")
	private Long idTitle;

	@Column(name = "id_season")
	private Long idSeason;

	public TitleSeasonKey() {

	}

	public TitleSeasonKey(String idKey) {
		String[] data = idKey.split("_");
		this.idTitle = Long.parseLong(data[0]);
		this.idSeason = Long.parseLong(data[1]);
	}

	public TitleSeasonKey(Long idTitle, Long idSeason) {
		this.idTitle = idTitle;
		this.idSeason = idSeason;
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

	@Override
	public String toString() {
		return String.valueOf(this.idTitle + "_" + this.idSeason);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		TitleSeasonKey other = (TitleSeasonKey) obj;
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

}
