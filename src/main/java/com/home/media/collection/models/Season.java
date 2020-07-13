package com.home.media.collection.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Season {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSeason;

	@Column(columnDefinition = "integer default 0")
	@Max(value = 100)
	@Min(value = 0)
	private Long season;

	@OneToMany(mappedBy = "season", fetch = FetchType.LAZY)
	Set<TitleSeason> titlesSeasons;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSeason == null) ? 0 : idSeason.hashCode());
		result = prime * result + ((season == null) ? 0 : season.hashCode());
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
		Season other = (Season) obj;
		if (idSeason == null) {
			if (other.idSeason != null)
				return false;
		} else if (!idSeason.equals(other.idSeason))
			return false;
		if (season == null) {
			if (other.season != null)
				return false;
		} else if (!season.equals(other.season))
			return false;
		return true;
	}

	protected Season() {
		super();
	}

	public Season(@Max(100) @Min(0) Long season) {
		super();
		this.season = season;
	}

	public Long getIdSeason() {
		return idSeason;
	}

	public void setIdSeason(Long idSeason) {
		this.idSeason = idSeason;
	}

	public Long getSeason() {
		return season;
	}

}
