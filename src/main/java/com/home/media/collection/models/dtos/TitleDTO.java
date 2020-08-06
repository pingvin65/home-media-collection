package com.home.media.collection.models.dtos;

public class TitleDTO {

	private String title;

	private String path;

	private Long type_id;

	private boolean is_series;

	public TitleDTO() {

	}

	public TitleDTO(String title, String path, Long type_id, boolean is_series) {
		super();
		this.title = title;
		this.path = path;
		this.type_id = type_id;
		this.is_series = is_series;
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

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}

	public boolean isIs_series() {
		return is_series;
	}

	public void setIs_series(boolean is_series) {
		this.is_series = is_series;
	}

}
