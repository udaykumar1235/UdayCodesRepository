package com.uday.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uday.springcloud.Entities.ClinicalData;
import com.uday.springcloud.Entities.Patient;
import com.uday.springcloud.repository.PatientRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {
	
	private PatientRepository patientRepository;
	
	Map<String, String> filters = new HashMap<>();

	public PatientController(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		
		return patientRepository.findAll();
	}
	
	@GetMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable("id") int id) {
		
		return patientRepository.findById(id).get();
		
	}

	@PostMapping("/patients")
	public Patient savePatient(@RequestBody Patient patient) {
		
		return patientRepository.save(patient);
	}
	
	@GetMapping("/patients/analyze/{id}")
	public Patient analyze(@PathVariable("id") int id) {
		
		Patient patient = patientRepository.findById(id).get();
		
		List<ClinicalData> clinicalDatas = patient.getClinicalData();
		List<ClinicalData> duplicatesClinicalData = new ArrayList<>(clinicalDatas);
		
		for(ClinicalData eachEntry: duplicatesClinicalData) {
			
			if(filters.containsKey(eachEntry.getComponentName())) {
				
				clinicalDatas.remove(eachEntry);
				continue;
			}else {
				filters.put(eachEntry.getComponentName(), null);
			}
			
			if(eachEntry.getComponentName().equals("hw")) {
				
			String[] heightAndWeight =	eachEntry.getComponentValue().split("/");
			
			if(heightAndWeight !=null && heightAndWeight.length > 1) {
				
				float heigthMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
				float bmi = Float.parseFloat(heightAndWeight[1] ) / (heigthMeters * heigthMeters);
				
				ClinicalData bmiData = new ClinicalData();
				bmiData.setComponentName("bmi");
				bmiData.setComponentValue(Float.toString(bmi));
				clinicalDatas.add(bmiData);
			}
	
			}
		}
				
		filters.clear();
		return patient;
	}
	
}
