package com.uday.springcloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.uday.springcloud.Entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
