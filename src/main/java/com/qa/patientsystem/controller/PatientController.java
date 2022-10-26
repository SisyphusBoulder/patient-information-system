package com.qa.patientsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.patientsystem.entity.Patient;
import com.qa.patientsystem.entity.Treatment;
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
	public ResponseEntity<?> findByPatientLocation(@PathVariable("location") String location){
		try {
			List<Patient> patientList = this.patientService.findByPatientLocation(location);
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/patients/condition/{condition}")
	public ResponseEntity<?> findByPatientCondition(@PathVariable("condition") String condition){
		try {
			List<Patient> patientList = this.patientService.findByPatientCondition(condition);
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/patients/age/{age}")
	public ResponseEntity<?> findByPatientLocation(@PathVariable("age") byte age){
		try {
			List<Patient> patientList = this.patientService.findByPatientAge(age);
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/patients/insurance/{isInsured}")
	public ResponseEntity<?> findByPatientInsurance(@PathVariable("isInsured") boolean isInsured){
		try {
			List<Patient> patientList = this.patientService.findByPatientInsurance(isInsured);
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/patients/sex/{sex}")
	public ResponseEntity<?> findByPatientSex(@PathVariable("sex") char sex){
		try {
			List<Patient> patientList = this.patientService.findByPatientSex(sex);
			responseEntity = new ResponseEntity<>(patientList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Some internal server error occured!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
}