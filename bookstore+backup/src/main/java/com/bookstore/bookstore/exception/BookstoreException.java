package com.bookstore.bookstore.exception;

public class BookstoreException extends RuntimeException {

	
	public BookstoreException(String message) {
		super(message);
	}
	
	public BookstoreException(String message, Throwable t) {
		super(message, t);
	}
}
