package com.qa.patientsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.patientsystem.dto.PatientDto;
import com.qa.patientsystem.entity.Patient;
import com.qa.patientsystem.entity.Treatment;
import com.qa.patientsystem.exception.InvalidLoginDataException;
import com.qa.patientsystem.exception.PatientAlreadyExistsException;
import com.qa.patientsystem.exception.PatientNotFoundException;

@Service
public interface IPatientService {
	
	public List<Patient> getAllPatients();
	
	public List<Treatment> getAllTreatments();
	
	public List<Patient> findByPatientLocation(String location);
	public List<Patient> findByPatientillness(String illness);
	public List<Patient> findByPatientAge(int age);
	public List<Patient> findByPatientInsurance(boolean insured);
	public List<Patient> findByPatientSex(char sex);
	
	public Patient getPatientById(int id) throws PatientNotFoundException;
	public Patient getPatientByName(String name) throws PatientNotFoundException;

	Patient updatePatientDetails(int id, String location, boolean insured) throws PatientNotFoundException;

	Patient addPatient(Patient patient) throws PatientAlreadyExistsException, PatientNotFoundException;

	Patient updatePatient(Patient patient) throws PatientNotFoundException;

	boolean deletePatient(int id) throws PatientNotFoundException;

	PatientDto login(int id, String email, String password) throws PatientNotFoundException, InvalidLoginDataException;
}