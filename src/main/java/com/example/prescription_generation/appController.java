package com.example.prescription_generation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.prescription_generation.Patient;
import com.example.prescription_generation.PatientService;

@Controller
public class appController {
	@Autowired
	private PatientService service;
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Patient> listPatients=service.listAll();
		model.addAttribute("listPatients", listPatients);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewPatientPage(Model model) {
	    Patient patient = new Patient();
	    model.addAttribute("patient", patient);
	     
	    return "new_patient";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePatient(@ModelAttribute("patient") @Validated Patient patient) {
	    service.save(patient);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditPatientPage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("edit_patient");
	    Patient patient = service.get(id);
	    mav.addObject("patient", patient);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePatient(@PathVariable(name = "id") Long id) {
		
		service.delete(id);
	    return "redirect:/";       
	}
	PatientRepository p;
	@GetMapping("/api")
	public List getPatient() {
		return p.findAll();
		
	}
	
	@RequestMapping("/out")
	public String outt() {
	     
	    return "outer";
	}
	
	@RequestMapping("/exter")
	public String exte() {
	     
	    return "external";
	}
	PatientRepository rep;
	@RequestMapping("/report")
	public String re() {
	    System.out.println(service.countTotalPatientByPrescription_date());
	    return "outer";
	}
	
	
}
