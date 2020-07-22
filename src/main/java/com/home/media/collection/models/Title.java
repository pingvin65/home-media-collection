package com.home.media.collection.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedAttributeNode;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@NamedEntityGraph(name = "Title.detail", attributeNodes = @NamedAttributeNode("titlesSeasons"))
@Table(name = "titles", uniqueConstraints = { @UniqueConstraint(columnNames = { "title", "id_type", "is_series" }) })
public class Title {

	@Id
	@Column(name = "id_title")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTitle;

	@Column(name = "title", nullable = false)
	@NotBlank(message = "Title may not be blank")
	@NotNull(message = "Title may not be null")
	private String title;

	@JoinColumn(name = "path_picture")
	private String path;

	@Column(name = "create_date")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date createDate;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_type", nullable = false)
	private Type type;

	@Column(name = "is_series", columnDefinition = "boolean default true")
	private boolean isSeries;

	@ManyToMany(mappedBy = "titles", fetch = FetchType.LAZY)
	Set<Genre> genres = new HashSet<>();

	@OneToMany(mappedBy = "title", fetch = FetchType.LAZY)
	List<TitleSeason> titlesSeasons = new ArrayList<TitleSeason>();

	protected Title() {
		super();
	}

	public Title(@NotBlank(message = "Title may not be blank") @NotNull(message = "Title may not be null") String title,
			String path, Type type, boolean isSeries) {
		super();
		this.title = title;
		this.path = path;
		this.type = type;
		this.isSeries = isSeries;
	}

	public Title(@NotBlank(message = "Title may not be blank") @NotNull(message = "Title may not be null") String title,
			Date createDate) {
		super();
		this.title = title;
		this.createDate = createDate;
	}
//
//	public Title(Long idTitle,
//			@NotBlank(message = "Title may not be blank") @NotNull(message = "Title may not be null") String title,
//			String path, boolean isSeries, Date createDate) {
//		super();
//		this.idTitle = idTitle;
//		this.title = title;
//		this.path = path;
//		this.isSeries = isSeries;
//		this.createDate = createDate;
//	}
//
//	public Title(@NotBlank(message = "Title may not be blank") @NotNull(message = "Title may not be null") String title,
//			String path, Type type, boolean isSeries) {
//		super();
//		this.title = title;
//		this.path = path;
//		this.type = type;
//		this.isSeries = isSeries;
//	}
//
//	public Title(@NotBlank(message = "Title may not be blank") @NotNull(message = "Title may not be null") String title,
//			String path, Date createDate, Type type, boolean isSeries) {
//		super();
//		this.title = title;
//		this.path = path;
//		this.createDate = createDate;
//		this.type = type;
//		this.isSeries = isSeries;
//	}
//
//	
//	
//	public Title(@NotBlank(message = "Title may not be blank") @NotNull(message = "Title may not be null") String title,
//			String path, Type type, boolean isSeries, Set<Genre> genres) {
//		super();
//		this.title = title;
//		this.path = path;
//		this.type = type;
//		this.isSeries = isSeries;
//		this.genres = genres;
//	}

	public Long getIdTitle() {
		return idTitle;
	}

	public void setIdTitle(Long idTitle) {
		this.idTitle = idTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isSeries() {
		return isSeries;
	}

	public void setSeries(boolean isSeries) {
		this.isSeries = isSeries;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((idTitle == null) ? 0 : idTitle.hashCode());
		result = prime * result + (isSeries ? 1231 : 1237);
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Title other = (Title) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (idTitle == null) {
			if (other.idTitle != null)
				return false;
		} else if (!idTitle.equals(other.idTitle))
			return false;
		if (isSeries != other.isSeries)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
