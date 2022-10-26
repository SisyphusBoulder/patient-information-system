package com.qa.patientsystem.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Patient> findByPatientLocation(String location) {
		
		return this.patientRepository.findByPatientLocation(location);
	}

	@Override
	public List<Patient> findByPatientCondition(String condition) {
		return this.patientRepository.findByPatientCondition(condition);
	}

	@Override
	public List<Patient> findByPatientAge(byte age) {
		return this.patientRepository.findByPatientAge(age);
	}

	@Override
	public List<Patient> findByPatientInsurance(boolean isInsured) {
		return this.patientRepository.findByPatientInsurance(isInsured);
	}

	@Override
	public List<Patient> findByPatientSex(char sex) {
		return this.patientRepository.findByPatientSex(sex);
	}

	@Override
	public Patient getPatientById(int id) {
		return this.patientRepository.getPatientById(id);
	}

	@Override
	public Patient getPatientByName(String name) {
		return this.patientRepository.getPatientByName(name);	
		}
}
