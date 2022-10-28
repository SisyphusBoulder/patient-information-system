package com.qa.patientsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.patientsystem.dto.PatientDto;
import com.qa.patientsystem.entity.Patient;
import com.qa.patientsystem.entity.Treatment;
import com.qa.patientsystem.exception.InvalidLoginDataException;
import com.qa.patientsystem.exception.PatientAlreadyExistsException;
import com.qa.patientsystem.exception.PatientNotFoundException;
import com.qa.patientsystem.service.PatientServiceImplementation;


@RestController
@RequestMapping("api/v1")
public class PatientController {

	@Autowired
	PatientServiceImplementation patientService;

	ResponseEntity<?> responseEntity;

	@GetMapping("/patients")
	public ResponseEntity<?> getAllPatients(){
		try {
			List<Patient> patientList = this.patientService.getAllPatients();
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}

	@GetMapping("/treatments")
	public ResponseEntity<?> getAllTreatments(){
		try {
			List<Treatment> patientList = this.patientService.getAllTreatments();
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}

	@GetMapping("/patients/location/{location}")
	public ResponseEntity<?> findByPatientLocation(@Valid @PathVariable("location") String location){
		try {
			List<Patient> patientList = this.patientService.findByPatientLocation(location);
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/patients/condition/{condition}")
	public ResponseEntity<?> findByPatientCondition(@Valid @PathVariable("condition") String condition){
		try {
			List<Patient> patientList = this.patientService.findByPatientCondition(condition);
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/patients/age/{age}")
	public ResponseEntity<?> findByPatientLocation(@Valid @PathVariable("age") byte age){
		try {
			List<Patient> patientList = this.patientService.findByPatientAge(age);
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/patients/insurance/{isInsured}")
	public ResponseEntity<?> findByPatientInsurance(@Valid @PathVariable("isInsured") boolean isInsured){
		try {
			List<Patient> patientList = this.patientService.findByPatientInsurance(isInsured);
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/patients/sex/{sex}")
	public ResponseEntity<?> findByPatientSex(@Valid @PathVariable("sex") char sex){
		try {
			List<Patient> patientList = this.patientService.findByPatientSex(sex);
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/patients/id/{id}")
	public ResponseEntity<?> getPatientById(@Valid @PathVariable("id") int id) throws PatientNotFoundException{
		try {
			Patient patient = this.patientService.getPatientById(id);
			responseEntity = new ResponseEntity<>(patient, HttpStatus.OK);
		}catch(PatientNotFoundException e) {
			throw e;
		}catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/patients/name/{name}")
	public ResponseEntity<?> getPatientByName(@Valid @PathVariable("name") String name) throws PatientNotFoundException{
		try {
			Patient patient = this.patientService.getPatientByName(name);
			responseEntity = new ResponseEntity<>(patient, HttpStatus.OK);
		}catch(PatientNotFoundException e) {
			throw e;
		}catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@PostMapping("/patients/signup")
	public ResponseEntity<?> addPatient(@RequestBody Patient patient) throws PatientAlreadyExistsException{
		try {
			Patient addedPatient = this.patientService.addPatient(patient);
			System.out.println("Added patient successfully!" + addedPatient);
			responseEntity = new ResponseEntity<>(patient, HttpStatus.CREATED);
		} catch (PatientAlreadyExistsException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Some internal error occured...", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}
	
	@GetMapping("/patients/login")
	public ResponseEntity<?> patientLogin(@RequestBody Patient patient) throws PatientNotFoundException, InvalidLoginDataException{
		try {
			PatientDto selectedPatient = this.patientService.login(patient.getId(), patient.getEmail(), patient.getPassword());
			responseEntity = new ResponseEntity<>(selectedPatient, HttpStatus.OK);
		}catch(PatientNotFoundException e) {
			throw e;
		}catch (InvalidLoginDataException e) {
			throw e;
		}catch(Exception e){
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}

	@PutMapping("/patients")
	public ResponseEntity<?> updatePatient(@RequestBody Patient patient) throws PatientNotFoundException{
		try {
			Patient updatedPatient = this.patientService.updatePatient(patient);
			System.out.println("Updated patient successfully!" + updatedPatient);
			responseEntity = new ResponseEntity<>(patient, HttpStatus.OK);
		} catch (PatientNotFoundException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Some internal error occured...", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}

	@DeleteMapping("/patients/{id}")
	public ResponseEntity<?> deletePatient(@Valid @PathVariable("id") int id) throws PatientNotFoundException{
		try {
			boolean status = this.patientService.deletePatient(id);
			if(status) {
				responseEntity = new ResponseEntity<>("Deleted patient successfully!", HttpStatus.OK);
			}
		} catch (PatientNotFoundException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Some internal error occured...", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}
	
	@PutMapping("/patients/update_details")
	public ResponseEntity<?> updatePatientDetails(@RequestBody Patient patient) throws PatientNotFoundException{
		try {
			Patient updatedPatient = this.patientService.updatePatientDetails(patient.getId(), patient.getLocation(), patient.isInsured());
			responseEntity = new ResponseEntity<>(updatedPatient, HttpStatus.OK);
		} catch (PatientNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal error occurred!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
}