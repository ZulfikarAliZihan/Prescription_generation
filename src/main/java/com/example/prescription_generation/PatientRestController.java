package com.example.prescription_generation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientRestController {
	@Autowired
	PatientService patientService;
	@GetMapping("/api/v1/prescription")
	public List<Patient> getAllPatient(){
		return patientService.listAll();
	}
}
