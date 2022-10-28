package com.qa.patientsystem.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.qa.patientsystem.entity.Patient;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PatientRepositoryTest {
	
	@Autowired
	PatientRepository patientRepository;
	
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
	
	public void given_Patient_To_Save_Should_Return_The_Saved_Patient() {
		Patient savedPatient = patientRepository.save(patient1);
		assertNotNull(savedPatient);
		assertEquals("patient1", savedPatient.getName());
	}
	
	@Test
	@DisplayName("get-patients-as-list-test")
	public void given_GetAllPatients_Should_Return_Patient_List() {
		patientRepository.save(patient1);
		patientRepository.save(patient2);
		patientRepository.save(patient3);
		patientRepository.save(patient4);
		
		List<Patient> patientList = patientRepository.findAll();
		assertEquals(4, patientList.size(), "Patient list size should be 4");
		assertEquals("patient2", patientList.get(1).getName(), "Patient at index 1 should be named patient2");
	}
	
	@Test
	@DisplayName("get-patient-non-existing-id-test")
	public void given_Non_Existing_Id_Should_Return_Optional_Empty() {
		patientRepository.save(patient1);
		assertThat(patientRepository.findById(2)).isEmpty();
	}

}
