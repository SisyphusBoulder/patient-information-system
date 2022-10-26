package com.qa.patientsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.patientsystem.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	List<Patient> findByPatientSex(char sex);
	List<Patient> findByPatientCondition(String condition);
	List<Patient> findByPatientLocation(String location);
	List<Patient> findByPatientAge(byte age);
	List<Patient> findByPatientInsurance(Boolean isInsured);
}
