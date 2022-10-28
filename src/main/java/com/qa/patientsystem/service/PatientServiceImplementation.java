package com.qa.patientsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.qa.patientsystem.dto.PatientDto;
import com.qa.patientsystem.entity.Patient;
import com.qa.patientsystem.entity.Treatment;
import com.qa.patientsystem.exception.InvalidLoginDataException;
import com.qa.patientsystem.exception.PatientAlreadyExistsException;
import com.qa.patientsystem.exception.PatientNotFoundException;
import com.qa.patientsystem.repository.PatientRepository;
import com.qa.patientsystem.repository.TreatmentRepository;

@Service
public class PatientServiceImplementation implements IPatientService {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	TreatmentRepository treatmentRepository;

	@Autowired
	ModelMapper modelMapper;


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
	public List<Patient> findByPatientillness(String illness) {
		return this.patientRepository.findByPatientillness(illness);
	}

	@Override
	public List<Patient> findByPatientAge(int age) {
		return this.patientRepository.findByPatientAge(age);
	}

	@Override
	public List<Patient> findByPatientInsurance(boolean insured) {
		return this.patientRepository.findByPatientInsurance(insured);
	}

	@Override
	public List<Patient> findByPatientSex(char sex) {
		return this.patientRepository.findByPatientSex(sex);
	}

	@Override
	public Patient getPatientById(int id) throws PatientNotFoundException{
		Patient foundPatient = this.patientRepository.getPatientById(id);
		if(foundPatient == null) {
			throw new PatientNotFoundException("This patient does not exist!");
		}
		return foundPatient;
	}

	@Override
	public Patient getPatientByName(String name) throws PatientNotFoundException {
		Patient foundPatient = this.patientRepository.getPatientByName(name);
		if(foundPatient == null) {
			throw new PatientNotFoundException("This patient does not exist!");
		}
		return foundPatient;
	}

	//	@Override
	//	public Patient addPatient(Patient patient) throws PatientAlreadyExistsException, PatientNotFoundException{
	//		Patient newPatient = null;
	//		try {
	//			Patient patientExists = getPatientById(patient.getId());
	//			if(patientExists != null) {
	//				throw new PatientAlreadyExistsException("This patient already exists!");
	//			}
	//		} catch (PatientNotFoundException e) {
	//			newPatient =  this.patientRepository.save(patient);
	//			//e.printStackTrace();
	//		}
	//		return newPatient;
	//	}

	@Override
	public Patient addPatient(Patient patient) throws PatientAlreadyExistsException{
		
		System.out.println(patient);

		Optional<Patient> optionalPatientFoundByID = this.patientRepository.findById(patient.getId());

		if (optionalPatientFoundByID.isPresent()) {
			throw new PatientAlreadyExistsException("This patient already exists!");
		}

		return this.patientRepository.save(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) throws PatientNotFoundException {
		Optional<Patient> updatedPatient = null;
		updatedPatient = this.patientRepository.findById(patient.getId());
		if(!updatedPatient.isPresent()) {
			throw new PatientNotFoundException("Patient does not exist!");
		}
		else {
			return this.patientRepository.save(patient);
		}

	}

	@Override
	public boolean deletePatient(int id) throws PatientNotFoundException {
		boolean status = false;
		Optional<Patient> deletedPatient = null;
		deletedPatient = this.patientRepository.findById(id);
		if(!deletedPatient.isPresent()) {
			throw new PatientNotFoundException("Patient does not exist!");
		}
		this.patientRepository.delete(deletedPatient.get());		
		status = true;

		return status;
	}

	@Override
	public PatientDto login(int id, String email, String password) throws PatientNotFoundException, InvalidLoginDataException{
		Optional<Patient> findPatientById = this.patientRepository.findById(id);
		Patient selectedPatient = null;
		if(!findPatientById.isPresent()) {
			throw new PatientNotFoundException("Patient does not exist!");
		}
		else {
			selectedPatient = findPatientById.get();

			if(!(selectedPatient.getEmail().equals(email)) || !(selectedPatient.getPassword().equals(password))) {
				throw new InvalidLoginDataException("Email or password is incorrect!");
			}
			else {
				System.out.println("login successful");;
			}
		}
		return mapToPatientDto(selectedPatient);
	}

	@Override
	public Patient updatePatientDetails(int id, String location, boolean insured) throws PatientNotFoundException {
		Patient updatedPatient = null;
		Optional<Patient> findPatientById = this.patientRepository.findById(id);
		if(!findPatientById.isPresent()) {
			throw new PatientNotFoundException("Patient does not exist!");
		}
		else {
			int rows = this.patientRepository.updatePatientDetails(id, location, insured);
			if(rows > 0) {
				updatedPatient = this.patientRepository.findById(id).get();
			}
		}
		return updatedPatient;
	}

	private PatientDto mapToPatientDto(Patient patient) {
		return this.modelMapper.map(patient, PatientDto.class);
	}
}
