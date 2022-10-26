package com.qa.patientsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Patient does not exist!")
public class PatientNotFoundException extends Exception {

	public PatientNotFoundException(String msg) {
		super(msg);
	}

}
