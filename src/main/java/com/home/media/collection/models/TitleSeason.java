package com.home.media.collection.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TitleSeason implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 176666219935328340L;

	@EmbeddedId
	private TitleSeasonKey id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_title", insertable = false, updatable = false)
	private Title title;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_season", insertable = false, updatable = false)
	private Season season;

	private String picture;

	private String description;

	public TitleSeason() {
	}

	public TitleSeason(Long idTitle, Long idSeason, String picture, String description) {
		this.id = new TitleSeasonKey(idTitle, idSeason);
		this.picture = picture;
		this.description = description;
	}

	public TitleSeason(TitleSeasonKey id, String picture, String description) {
		this.id = id;
		this.picture = picture;
		this.description = description;
	}

	protected TitleSeason(TitleSeasonKey id) {
		super();
		this.id = id;
	}

	public TitleSeasonKey getId() {
		return id;
	}

	public void setId(TitleSeasonKey id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
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
		TitleSeason other = (TitleSeason) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		return true;
	}

}