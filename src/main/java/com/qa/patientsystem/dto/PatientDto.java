package com.qa.patientsystem.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PatientDto {
	
	private int id;
	private String name;
	private String email;
	private byte age;
	private String location;

}
