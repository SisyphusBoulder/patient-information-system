package com.qa.patientsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Max;
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
@Table(name = "treatment")
public class Treatment {
	
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
	@Column(name = "price")
	private float price;
	
	@NotNull
	@Column(name = "is_available")
	private boolean isAvailable;

}
