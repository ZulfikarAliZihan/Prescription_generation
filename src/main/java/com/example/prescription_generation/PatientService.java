package com.example.prescription_generation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	@Autowired
	private PatientRepository repo;
	public List<Patient> listAll(){
		return repo.findAll();
	}
	   public void save(Patient patient) {
	        repo.save(patient);
	    }
	     
	    public Patient get(long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
	    
	    public List<Patient> countTotalPatientByPrescription_date() {
	        return repo.countTotalPatientByPrescription_date();
	    }
	    
}
