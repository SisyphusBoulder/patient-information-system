package com.qa.patientsystem.service;

import java.util.List;
import java.util.Optional;

import com.qa.patientsystem.entity.Patient;
import com.qa.patientsystem.entity.Treatment;
import com.qa.patientsystem.exception.PatientAlreadyExistsException;
import com.qa.patientsystem.exception.PatientNotFoundException;

public interface IPatientService {
	
	public List<Patient> getAllPatients();
	
	public List<Treatment> getAllTreatments();
	
	public List<Patient> findByPatientLocation(String location);
	public List<Patient> findByPatientCondition(String condition);
	public List<Patient> findByPatientAge(byte age);
	public List<Patient> findByPatientInsurance(boolean isInsured);
	public List<Patient> findByPatientSex(char sex);
	
	public Patient getPatientById(int id) throws PatientNotFoundException;
	public Patient getPatientByName(String name) throws PatientNotFoundException;

	Patient updatePatientDetails(int id, String location, boolean isInsured) throws PatientNotFoundException;

	Patient addPatient(Patient patient) throws PatientAlreadyExistsException, PatientNotFoundException;

	Patient updatePatient(Patient patient) throws PatientNotFoundException;

	boolean deletePatient(int id) throws PatientNotFoundException;
}