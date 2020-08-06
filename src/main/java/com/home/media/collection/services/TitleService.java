package com.home.media.collection.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.media.collection.models.Title;
import com.home.media.collection.models.Type;
import com.home.media.collection.models.dtos.TitleDTO;
import com.home.media.collection.properties.HomeMediaCollectionProperties;
import com.home.media.collection.repositories.TitleRepository;
import com.home.media.collection.repositories.TypeRepository;

@Service
public class TitleService {

	private static final Logger logger = LoggerFactory.getLogger(TitleService.class);

	private HomeMediaCollectionProperties hmcProperties;

	@Autowired
	private TitleRepository titleRepository;

	@Autowired
	private TypeRepository typeRepository;

	public TitleService(TitleRepository titleRepository, TypeRepository typeRepository) {
		super();
		this.titleRepository = titleRepository;
		this.typeRepository = typeRepository;
	}

	public Title saveTitle(String titleDTO, MultipartFile multipartFile) {

		TitleDTO titleDTOjson = new TitleDTO();

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			titleDTOjson = objectMapper.readValue(titleDTO, TitleDTO.class);
			this.saveFileOnUploadDir(multipartFile, titleDTOjson.getTitle());
		} catch (IOException error) {
			logger.error(error.getMessage());
		}
		logger.info("------> {}", multipartFile.getOriginalFilename());
		Type type = typeRepository.findById(titleDTOjson.getType_id()).orElseThrow();
		Title title = new Title(titleDTOjson.getTitle(), titleDTOjson.getPath(), type, titleDTOjson.isIs_series());
		titleRepository.save(title);
		logger.info("title {}", title.getIdTitle());
		return title;

	}

	private void saveFileOnUploadDir(MultipartFile multipartFile, String fileName) throws IOException {
		if (! multipartFile.isEmpty()) {
			hmcProperties = new HomeMediaCollectionProperties();
			String[] pictureExtensions = hmcProperties.getPictureExtensions();
			InputStream fileStream = multipartFile.getInputStream();
			String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
			for (int i=0; i < pictureExtensions.length; i++) {
				if(pictureExtensions[i].equals(extension)) {
					logger.info("----> {}", extension);
					File targetFile = new File(hmcProperties.getApsolutePathUploadDir() + fileName + "." + extension);
					FileUtils.copyInputStreamToFile(fileStream, targetFile);
					break;
				}
			}

		}


	}

}
