package com.home.media.collection.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Genre {

	@Id
	@Column(name = "id_genre")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGenre;

	@Column(nullable = false, unique = true, length = 32)
	private String name;

	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "titles_genres", joinColumns = {
			@JoinColumn(name = "id_genre", referencedColumnName = "id_genre", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_title", referencedColumnName = "id_title", nullable = false, updatable = false) })
	Set<Title> titles = new HashSet<>();

	public Genre() {
		super();
	}

	public Genre(String name, String description) {
		super();

		this.name = name;
		this.description = description;
	}

	public Long getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(Long idGenre) {
		this.idGenre = idGenre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
