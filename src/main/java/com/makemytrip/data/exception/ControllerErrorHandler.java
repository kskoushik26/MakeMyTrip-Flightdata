package com.makemytrip.data.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//ControllerErrorHandler class handle all the exception for the UserController Rest Service
@ControllerAdvice
public class ControllerErrorHandler {

	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<Object> handleUserNotExistException(FlightNotFoundException exception) {
		
		ErrorResponse errorResponse=new ErrorResponse(new Date(),HttpStatus.NOT_FOUND.value(),exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FlightFoundException.class)
	public ResponseEntity<Object> handleAlreadyUserExistException(FlightFoundException exception) {
		
		ErrorResponse errorResponse=new ErrorResponse(new Date(),HttpStatus.BAD_REQUEST.value(),exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
		
		ErrorResponse errorResponse=new ErrorResponse(new Date(),HttpStatus.BAD_REQUEST.value(),exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoFlightFoundException.class)
	public ResponseEntity<Object> handleNoUserExistException(NoFlightFoundException exception) {
		
		ErrorResponse errorResponse=new ErrorResponse(new Date(),HttpStatus.NOT_FOUND.value(),exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception exception) {
		
		ErrorResponse errorResponse=new ErrorResponse(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error");
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
