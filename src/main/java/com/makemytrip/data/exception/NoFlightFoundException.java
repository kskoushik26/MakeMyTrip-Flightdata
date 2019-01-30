package com.makemytrip.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFlightFoundException extends RuntimeException {

	public NoFlightFoundException(String errorMessage) {
		super(errorMessage);
	}
}
