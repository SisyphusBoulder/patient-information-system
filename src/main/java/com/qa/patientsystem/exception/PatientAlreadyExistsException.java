package com.qa.patientsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Patient already exists!")
public class PatientAlreadyExistsException extends Exception {

	public PatientAlreadyExistsException(String string) {
		super(string);
	}

}
