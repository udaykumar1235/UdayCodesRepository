package com.uday.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.springcloud.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
