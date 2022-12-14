package com.qa.patientsystem.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	
	@Query("select p from Patient p where p.illness = :illness")
	List<Patient> findByPatientillness(String illness);
	
	@Query("select p from Patient p where p.location = :location")
	List<Patient> findByPatientLocation(String location);
	
	@Query("select p from Patient p where p.age = :age")
	List<Patient> findByPatientAge(int age);
	
	@Query("select p from Patient p where p.insured = :insured")
	List<Patient> findByPatientInsurance(Boolean insured);
	
	@Modifying
	@Query("update Patient p set p.location = :location, p.insured = :insured where p.id = :id")
	int updatePatientDetails(int id, String location, boolean insured);

	Patient findByName(String name);
	
}
