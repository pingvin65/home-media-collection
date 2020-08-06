package com.home.media.collection.properties;

import java.io.File;

public class HomeMediaCollectionProperties {

	/**
	 * Folder location for storing files
	 */
	private String uploadDir = "uploads";

	/**
	 * Absolute project path
	 */
	private final String absoluteProjectPath = System.getProperty("user.dir");

	private final String[] pictureExtensions = { "png", "jpg", "gif", "svg" };

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public String getApsoluteProjectPath() {
		return absoluteProjectPath;
	}

	public String getApsolutePathUploadDir() {
		return this.absoluteProjectPath + File.separator + this.uploadDir + File.separator;
	}

	public String getApsolutePathUploadDir(String apsolutePathUploudDir) {
		return apsolutePathUploudDir;
	}

	public String getAbsoluteProjectPath() {
		return absoluteProjectPath;
	}

	public String[] getPictureExtensions() {
		return pictureExtensions;
	}

}
