package com.home.media.collection.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.minidev.json.JSONObject;

@ControllerAdvice // Makes this the default behaviour of all controllers
class GlobalControllerExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<List<JSONObject>> handleException(Exception ex) throws Exception {
		logger.error("Exception Occured: " + ex);

		List<JSONObject> listj = new ArrayList<JSONObject>();
		listj.add(new JSONObject().appendField("status", 500));
		listj.add(new JSONObject().appendField("Exception", ex.getLocalizedMessage()));

		return new ResponseEntity<List<JSONObject>>(listj, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex) {
		logger.info("SQLException Occured:: URL=" + request.getRequestURL());
		return "database_error";
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException() {
		logger.error("IOException handler executed");
		// returning 404 error code
	}
}
