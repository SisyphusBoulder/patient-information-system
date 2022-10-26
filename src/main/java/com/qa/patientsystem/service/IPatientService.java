package com.qa.patientsystem.service;

import java.util.List;

import com.qa.patientsystem.entity.Patient;
import com.qa.patientsystem.entity.Treatment;

public interface IPatientService {
	
	public List<Patient> getAllPatients();
	
	public List<Treatment> getAllTreatments();

}
