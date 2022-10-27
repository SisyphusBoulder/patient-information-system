package com.qa.patientsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Invalid Login Data!")
public class InvalidLoginDataException extends Exception {

	public InvalidLoginDataException(String string) {
		super(string);
	}

}
