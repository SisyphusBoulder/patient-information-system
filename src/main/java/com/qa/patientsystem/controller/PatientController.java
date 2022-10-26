package com.qa.patientsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.patientsystem.service.PatientServiceImplementation;

@RestController
@RequestMapping("api/v1")
public class PatientController {

	@Autowired
	PatientServiceImplementation patientService;
	
	ResponseEntity<?> responseEntity;
}
