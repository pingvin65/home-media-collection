package com.home.media.collection.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.media.collection.models.TitleSeasonKey;
import com.home.media.collection.repositories.TitleSeasonRepository;

@BasePathAwareController
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TitleSeasonController {

	private static final Logger logger = LoggerFactory.getLogger(TitleSeasonController.class);

	@Autowired
	private TitleSeasonRepository titleSeasonRepository;

	protected TitleSeasonController(TitleSeasonRepository titleSeasonRepository) {
		super();

		this.titleSeasonRepository = titleSeasonRepository;
	}

	@RequestMapping(value = "title-seasons/{id}", method = RequestMethod.DELETE)
	public HttpEntity<?> deleteBookById(@PathVariable(value = "id") TitleSeasonKey id) {

		try {
			logger.info("---> idKey {}", id);
			titleSeasonRepository.deleteById(id);
			return ResponseEntity.ok().build();

		} catch (ResourceNotFoundException ex) {

			logger.error(ex.getMessage());
			return ResponseEntity.notFound().build();

		}

	}

	@RequestMapping(value = "title-seasons", method = RequestMethod.DELETE)
	public HttpEntity<?> deleteAll() {

		try {

			titleSeasonRepository.deleteAll();

			return ResponseEntity.ok().build();

		} catch (ResourceNotFoundException ex) {

			logger.error(ex.getMessage());

			return ResponseEntity.notFound().build();

		}

	}

}
