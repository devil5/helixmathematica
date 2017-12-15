package com.titanhelix.hermes.controllers.rest;

import java.sql.Timestamp;

public class RestError {
	private String errorMessage;
	private Timestamp time;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}
