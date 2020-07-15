package com.home.media.collection.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Type {

	@Id
	@Column(name = "id_type")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idType;

	@Column(unique = true, nullable = false, length = 32)
	@JsonProperty("type-media")
	private String typeMedia;

	private String description;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "type", cascade = CascadeType.DETACH)

	private List<Title> titles;

	protected Type() {
		super();
	}

	public Type(String typeMedia, String description) {
		super();
		this.typeMedia = typeMedia;
		this.description = description;
	}

	public Long getIdType() {
		return idType;
	}

	public void setIdType(Long idType) {
		this.idType = idType;
	}

	public String getTypeMedia() {
		return typeMedia;
	}

	public void setTypeMedia(String typeMedia) {
		this.typeMedia = typeMedia;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

