package com.home.media.collection.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.media.collection.models.Title;
import com.home.media.collection.models.Type;
import com.home.media.collection.models.dtos.TitleDTO;
import com.home.media.collection.repositories.TitleRepository;
import com.home.media.collection.repositories.TypeRepository;

@Service
public class TitleService {

	private static final Logger logger = LoggerFactory.getLogger(TitleService.class);

	@Autowired
	private TitleRepository titleRepository;

	@Autowired
	private TypeRepository typeRepository;

	public TitleService(TitleRepository titleRepository, TypeRepository typeRepository) {
		super();
		this.titleRepository = titleRepository;
		this.typeRepository = typeRepository;
	}

	public Title saveTitle(TitleDTO titleDTO) {

		Type type = typeRepository.findById(titleDTO.getType_id()).orElseThrow();
		Title title = new Title(titleDTO.getTitle(), titleDTO.getPath(), type, titleDTO.isIs_series());
//		if(titleRepository.findByTitleAndTypeAndIsSeries(titleDTO.getTitle(), type, titleDTO.isIs_series()).isPresent()) {
//			logger.info("--> duble");
//		}
		titleRepository.save(title);
		logger.info("title {}", title.getIdTitle());
		return title;

	}

}
