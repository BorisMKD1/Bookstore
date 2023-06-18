package com.bookstore.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookstoreExceptionHandler {

	@ExceptionHandler(value = {BookstoreException.class})
	public ResponseEntity<Object> handleBadRequest(BookstoreException exception){
		ExceptionDetails details = new ExceptionDetails();
		details.setMessage(exception.getMessage());
		details.setHttpStatus(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}
}
