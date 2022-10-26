package com.qa.patientsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class PatientInformationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientInformationSystemApplication.class, args);
	}

}
