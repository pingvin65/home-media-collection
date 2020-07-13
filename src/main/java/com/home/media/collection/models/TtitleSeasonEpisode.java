package com.home.media.collection.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TtitleSeasonEpisode {

	@EmbeddedId
	private TtitleSeasonEpisodeKey id;

	@ManyToOne
	@JoinColumn(name = "id_episode", referencedColumnName = "id_episode", insertable = false, updatable = false)
	private Episode episodes;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "id_title", referencedColumnName = "id_title", insertable = false, updatable = false),
			@JoinColumn(name = "id_season", referencedColumnName = "id_season", insertable = false, updatable = false) })
	private TitleSeason titleSeason;

	private String description;

	@Column(name = "upload_date")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date uploadDate;

	@Column(name = "is_file", columnDefinition = "boolean default true")
	private boolean isFile;

	private String path;

	protected TtitleSeasonEpisode() {
	}

	public TtitleSeasonEpisode(TtitleSeasonEpisodeKey id, Episode episodes, String description, Date uploadDate,
			boolean isFile, String path) {
		this.id = id;
		this.episodes = episodes;

		this.description = description;
		this.uploadDate = uploadDate;
		this.isFile = isFile;
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public boolean isFile() {
		return isFile;
	}

	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
