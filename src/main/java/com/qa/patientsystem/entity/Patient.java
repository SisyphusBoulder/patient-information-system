package com.qa.patientsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "patient_details")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@Size(min=2, max=20, message = "name must be between 2 and 20 characters!")
	@Pattern(regexp = "^[A-Za-z0-9 ]*", message = "invalid name, must only contain alphabet characters!")
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Min(0)
	@Max(105)
	@Column(name = "age")
	private int age;
	
	//@NotBlank
	//@Pattern(regexp = "[FM]", message = "sex must be assigned as either F or M!")
	@Column(name = "sex")
	private char sex;
	
	@NotNull
	@Email(message = "Email must follow regular format!")
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Size(min=2, max=30, message = "location must be between 2 and 30 characters!")
	@Pattern(regexp = "^[A-Za-z0-9 ]*", message = "invalid name, must only contain alphabet characters!")
	@Column(name = "location")
	private String location;
	
	@NotNull
	@Column(name = "illness")
	private String illness;
	
	@NotNull
	@Column(name = "insured")
	private boolean insured;
	
	@NotNull
	@Size(min=5, max=20, message = "Password must be between 5 and 20 characters!")
	@Column(name = "pass")
	private String password;
	
	/*@NotNull
	@Column(name = "treatment")
	private Treatment treatment;*/
	

}
