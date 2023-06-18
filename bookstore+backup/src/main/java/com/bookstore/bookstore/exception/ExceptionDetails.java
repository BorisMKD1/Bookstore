package com.bookstore.bookstore.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDetails {
	
	private String message;
	private HttpStatus httpStatus; 

}
