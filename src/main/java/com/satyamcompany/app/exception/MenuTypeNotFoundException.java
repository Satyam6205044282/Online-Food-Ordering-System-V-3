package com.satyamcompany.app.exception;

public class MenuTypeNotFoundException extends RuntimeException{

	public MenuTypeNotFoundException() {
		super();

	}

	public MenuTypeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public MenuTypeNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public MenuTypeNotFoundException(String message) {
		super(message);

	}

	public MenuTypeNotFoundException(Throwable cause) {
		super(cause);

	}

	
}
