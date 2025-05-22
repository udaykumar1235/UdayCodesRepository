package com.uday.springcloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.uday.springcloud.Entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
