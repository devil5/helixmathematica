package com.titanhelix.mathematica.controllers.rest;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 * Exception Handler for invalid parameters
 */
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ConversionFailedException.class, MessageConversionException.class, NumberFormatException.class })
	protected ResponseEntity<Object> handleInvalidInput(RuntimeException e, WebRequest request) {
		return handleExceptionInternal(e, HttpStatus.BAD_REQUEST, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
