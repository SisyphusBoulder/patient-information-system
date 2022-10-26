package com.qa.patientsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.patientsystem.repository.PatientRepository;
import com.qa.patientsystem.repository.TreatmentRepository;

@Service
public class PatientServiceImplementation implements IPatientService {

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	TreatmentRepository treatmentRepository;
}
