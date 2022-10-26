package com.qa.patientsystem.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.patientsystem.entity.Patient;

@Repository
@Transactional
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	
	@Query("select p from Patient p where p.id = :id")
	Patient getPatientById(int id);
	
	@Query("select p from Patient p where p.name = :name")
	Patient getPatientByName(String name);
	
	@Query("select p from Patient p where p.sex = :sex")
	List<Patient> findByPatientSex(char sex);
	
	@Query("select p from Patient p where p.condition = :condition")
	List<Patient> findByPatientCondition(String condition);
	
	@Query("select p from Patient p where p.location = :location")
	List<Patient> findByPatientLocation(String location);
	
	@Query("select p from Patient p where p.age = :age")
	List<Patient> findByPatientAge(byte age);
	
	@Query("select p from Patient p where p.isInsured = :isInsured")
	List<Patient> findByPatientInsurance(Boolean isInsured);
	
	
}
