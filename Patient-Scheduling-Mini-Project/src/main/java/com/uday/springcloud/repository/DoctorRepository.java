package com.uday.springcloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.uday.springcloud.Entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
