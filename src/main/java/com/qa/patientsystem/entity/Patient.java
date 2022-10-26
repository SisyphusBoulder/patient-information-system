package com.qa.patientsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@Size(min=2, max=20, message = "name must be between 2 and 20 characters!")
	@Pattern(regexp = "^[A-Za-z]*", message = "invalid name, must only contain alphabet characters!")
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Min(0)
	@Max(105)
	@Column(name = "age")
	private byte age;
	
	@NotBlank
	@Pattern(regexp = "[FM]", message = "sex must be assigned as either F or M!")
	private char sex;
	
	@NotBlank
	@Email(message = "Email must follow regular format!")
	private String email;
	
	@NotBlank
	@Size(min=2, max=30, message = "location must be between 2 and 30 characters!")
	@Pattern(regexp = "^[A-Za-z]*", message = "invalid name, must only contain alphabet characters!")
	@Column(name = "location")
	private String location;
	
	@NotBlank
	@Column(name = "condition")
	private String condition;
	@NotNull
	
	@Column(name = "is_insured")
	private boolean isInsured;
	
	
	
	//Awaiting implementation of Treatment constructor
	/*@NotNull
	@Column(name = "treatment")
	private Treatment treatment;
	*/

}
