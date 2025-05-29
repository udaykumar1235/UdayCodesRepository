package com.uday.springcloud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uday.springcloud.Entities.ClinicalData;
import com.uday.springcloud.Entities.Patient;
import com.uday.springcloud.dtos.ClinicalDataRequest;
import com.uday.springcloud.repository.ClinicalDataRepository;
import com.uday.springcloud.repository.PatientRepository;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {

	private ClinicalDataRepository clinicalDataRepository;
	private PatientRepository patientRepository;
	
	public ClinicalDataController(ClinicalDataRepository clinicalDataRepository, PatientRepository patientRepository) {
		this.clinicalDataRepository = clinicalDataRepository;
		this.patientRepository = patientRepository;
	}

	@PostMapping("/clinicals")
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
		
		Patient patient = patientRepository.findById(request.getPatientId()).get();
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(request.getComponentName());
		clinicalData.setComponentValue(request.getComponentValue());
		clinicalData.setPatient(patient);
		
		return clinicalDataRepository.save(clinicalData);
		
	}
	
	
	
	
	
	
	
	
	
}
