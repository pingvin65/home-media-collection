package com.home.media.collection.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.home.media.collection.models.Title;
import com.home.media.collection.services.TitleService;

@BasePathAwareController
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TtitleController {
	private static final Logger logger = LoggerFactory.getLogger(TtitleController.class);

	@Autowired
	private TitleService titleService;

//	@RequestMapping(value = "titles", method = RequestMethod.POST, produces = "application/hal+json")
	@RequestMapping(value = "titles", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<?> saveTitle(@RequestParam("title") String titleDTO,
			@RequestParam("file") MultipartFile multipartFile) {

		logger.info("--------->  titles POST title = {} ", titleDTO);
//
		Title title = titleService.saveTitle(titleDTO, multipartFile);
//
		EntityModel<Title> model = EntityModel.of(title);
		return new ResponseEntity<>(model, HttpStatus.OK);

	}
}
