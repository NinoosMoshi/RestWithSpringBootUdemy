package com.ninos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnSupprtedMathException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UnSupprtedMathException(String exception) {
		super(exception);
	}

}
