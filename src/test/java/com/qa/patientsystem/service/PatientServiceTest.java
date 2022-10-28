package com.qa.patientsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.patientsystem.exception.PatientAlreadyExistsException;
import com.qa.patientsystem.exception.PatientNotFoundException;
import com.qa.patientsystem.entity.Patient;
import com.qa.patientsystem.repository.PatientRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PatientServiceTest {

	@Mock
	private PatientRepository patientRepository;

	@Autowired
	@InjectMocks
	private PatientServiceImplementation patientService;

	Patient patient1;
	Patient patient2;
	Patient patient3;
	Patient patient4;

	List<Patient> patientList;

	@BeforeEach
	public void setUp() {
		patient1 = new Patient(1, "patient1", (byte)27, 'M', "patient1@gmail.com", "London", "Liver damage", true, "password1");
		patient2 = new Patient(2, "patient2", (byte)53, 'M', "patient2@gmail.com", "Birmingham", "Influenza", false, "password2");
		patient3 = new Patient(3, "patient3", (byte)19, 'F', "patient3@gmail.com", "Manchester", "Hernia", false, "password3");
		patient4 = new Patient(4, "patient4", (byte)62, 'F', "patient4@gmail.com", "London", "Common cold", true, "password4");
		patientList = Arrays.asList(patient1, patient2, patient3, patient4);
	}

	@AfterEach
	public void tearDown() {
		patient1 = patient2 = patient3 = patient4 = null;
		patientList = null;
		patientRepository.deleteAll();
	}

	@Test
	@DisplayName("save-patient-test")
	public void given_Patient_To_Save_Should_Return_The_Saved_Patient() throws PatientAlreadyExistsException {
		when(patientRepository.findById(any())).thenReturn(Optional.empty());
		when(patientRepository.save(any())).thenReturn(patient1);
		Patient savedPatient = patientService.addPatient(patient1);
		System.out.println(savedPatient);
		assertNotNull(savedPatient);
		assertEquals(1,savedPatient.getId());
		verify(patientRepository,times(1)).findById(any());
		verify(patientRepository,times(1)).save(any());
	}

	@Test
	@DisplayName("save-patient-throws-exception-test")
	public void given_Existing_Patient_To_Save_Method_Should_Throw_Exception() throws PatientAlreadyExistsException {
		when(patientRepository.findById(any())).thenReturn(Optional.of(patient1));

		//patientService.addPatient(patient1);
		assertThrows(PatientAlreadyExistsException.class,()-> patientService.addPatient(patient1));
	}

}
