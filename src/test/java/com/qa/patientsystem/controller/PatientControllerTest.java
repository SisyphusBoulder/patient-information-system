package com.qa.patientsystem.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.patientsystem.entity.Patient;
import com.qa.patientsystem.entity.Treatment;
import com.qa.patientsystem.service.PatientServiceImplementation;


@ExtendWith(MockitoExtension.class)
public class PatientControllerTest {
	
	@Mock
	PatientServiceImplementation patientService;
	
	@Autowired
	@InjectMocks
	PatientController patientController;
	
	@Autowired
	private MockMvc mockMvc;
	
	Patient patient1;
	Patient patient2;
	Patient patient3;
	Patient patient4;
	
	List<Patient> patientList;
	
	Treatment treatment1;
	Treatment treatment2;
	Treatment treatment3;
	Treatment treatment4;
	
	List<Treatment> treatmentList;
	
	@BeforeEach
	public void setUp() {
		treatment1 = new Treatment(111, "treatment1", 9.99f, true);
		patient1 = new Patient(1, "patient1", (byte)27, 'M', "patient1@gmail.com", "London", "Liver damage", true, treatment1);
		treatment2 = new Treatment(222, "treatment2", 14.57f, true);
		patient2 = new Patient(2, "patient2", (byte)53, 'M', "patient2@gmail.com", "Birmingham", "Influenza", false, treatment2);
		treatment3 = new Treatment(333, "treatment3", 52.36f, false);
		patient3 = new Patient(3, "patient3", (byte)19, 'F', "patient3@gmail.com", "Manchester", "Hernia", false, treatment3);
		treatment4 = new Treatment(444, "treatment4", 5.95f, true);
		patient4 = new Patient(4, "patient4", (byte)62, 'F', "patient4@gmail.com", "London", "Common cold", true, treatment4);
		
		patientList = Arrays.asList(patient1, patient2, patient3, patient4);
		treatmentList = Arrays.asList(treatment1, treatment2, treatment3, treatment4);
		
		mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
	}
	
	@AfterEach
	public void tearDown() {
		patient1 = patient2 = patient3 = patient4 = null;
		treatment1 = treatment2 = treatment3 = treatment4 = null;
		patientList = null;
		treatmentList = null;
	}
	
	@Test
	@DisplayName("get-treatments-test")
	public void given_getAllTreatments_ShouldReturnList() throws Exception{
		when(patientService.getAllTreatments()).thenReturn(treatmentList);
		mockMvc.perform(get("/api/v1/treatments")
									.accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[1].name").value("treatment2"));
	}
	
	@Test
	@DisplayName("get-patients-test")
	public void given_getAllPatients_ShouldReturnList() throws Exception{
		when(patientService.getAllPatients()).thenReturn(patientList);
		mockMvc.perform(get("/api/v1/patients")
									.accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[2].name").value("patient3"));
	}
}
