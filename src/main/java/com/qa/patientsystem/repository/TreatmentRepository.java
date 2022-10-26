package com.qa.patientsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.patientsystem.entity.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer>{

}
