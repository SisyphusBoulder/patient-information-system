package com.qa.patientsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.patientsystem.entity.Patient;
import com.qa.patientsystem.entity.Treatment;
import com.qa.patientsystem.repository.PatientRepository;
import com.qa.patientsystem.repository.TreatmentRepository;

@Service
public class PatientServiceImplementation implements IPatientService {

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	TreatmentRepository treatmentRepository;

	@Override
	public List<Patient> getAllPatients() {
		return this.patientRepository.findAll();
	}

	@Override
	public List<Treatment> getAllTreatments() {
		return this.treatmentRepository.findAll();
	}
}
