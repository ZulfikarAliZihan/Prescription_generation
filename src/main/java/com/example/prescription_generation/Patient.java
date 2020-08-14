package com.example.prescription_generation;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;



@Entity
public class Patient {
	 private Long id;
     private String patient_name;
     private int age;
     private String gender;
     private String diagnosis;
     private String medicines;
	public Patient() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	private String prescription_date;
	
	public String getPrescription_date() {
		return prescription_date;
	}
	public void setPrescription_date(String prescription_date) {
		this.prescription_date = prescription_date;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	@Nullable
	private String next_visit_date=null;
	public String getNext_visit_date() {
		return next_visit_date;
	}
	public void setNext_visit_date(String next_visit_date) {
		this.next_visit_date = next_visit_date;
	}
     
}
