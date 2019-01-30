package com.makemytrip.data.exception;



import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.makemytrip.data.model.ApiResponse;

//ControllerErrorHandler class handle all the exception for the UserController Rest Service
@ControllerAdvice
public class ControllerErrorHandler {

	@ExceptionHandler(FlightNotFoundException.class)
	public ApiResponse<Object> handleFlightNotFoundException(FlightNotFoundException exception) {
		
		return new ApiResponse<>(HttpStatus.NOT_FOUND.value(),exception.getMessage(),null);
	}
	
	@ExceptionHandler(FlightFoundException.class)
	public ApiResponse<Object> handleFlightFoundException(FlightFoundException exception) {
		
		return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),exception.getMessage(),null);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ApiResponse<Object> handleBadRequestException(BadRequestException exception) {
		
		return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),exception.getMessage(),null);
	}
	
	@ExceptionHandler(NoFlightFoundException.class)
	public ApiResponse<Object> handleNoFlightFoundException(NoFlightFoundException exception) {
		
		return new ApiResponse<>(HttpStatus.NOT_FOUND.value(),exception.getMessage(),null);
	}
	
	@ExceptionHandler(Exception.class)
	public ApiResponse<Object> handleAllExceptions(Exception exception) {
		
		return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error",null);
	}
	
}
