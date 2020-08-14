package com.example.prescription_generation;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	@Query(value = "SELECT count(prescription_date) , prescription_date FROM Patient GROUP BY prescription_date", nativeQuery=true)
	List<Patient> countTotalPatientByPrescription_date();
}
