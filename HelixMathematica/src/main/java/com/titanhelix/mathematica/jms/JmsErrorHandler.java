package com.titanhelix.mathematica.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

/*
 * Error Handler - Primarily is instigated when bad request is sent
 */
@Service
public class JmsErrorHandler implements ErrorHandler {
	private static final Logger logger = LoggerFactory.getLogger(JmsErrorHandler.class);

	@Override
	public void handleError(Throwable t) {
		final String METHOD_NAME = "handleError()";
		logger.error(METHOD_NAME, t);
	}
}