package com.uday.springcloud;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uday.springcloud.Entities.Appointment;
import com.uday.springcloud.Entities.Doctor;
import com.uday.springcloud.Entities.Insurance;
import com.uday.springcloud.Entities.Patient;
import com.uday.springcloud.repository.AppointmentRepository;
import com.uday.springcloud.repository.DoctorRepository;
import com.uday.springcloud.repository.PatientRepository;

@SpringBootTest
class PatientSchedulingMiniProjectApplicationTests {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;

	@Test
	public void testCreateDoctor() {
		
		Doctor doctor = new Doctor();
		doctor.setFirstName("Uday");
		doctor.setLastName("Kiran");
		doctor.setSpeciality("Anything All");
		doctorRepository.save(doctor);
	}
	
	@Test
	public void testCreatePatient() {
		
		Patient patient = new Patient();
		patient.setFirstName("KK");
		patient.setLastName("Nike");
		patient.setPhone("70757588");
		
		Insurance insurance = new Insurance();
		insurance.setProviderName("Doly");
		insurance.setCopay(20d);
		
		Doctor doctor = doctorRepository.findById(1L).get();
		
		List<Doctor> doctors = Arrays.asList(doctor);
		patient.setDoctors(doctors);
		
		patient.setInsurance(insurance);
		
		patientRepository.save(patient);
	}

	@Test
	public void testCreateAppointment() {
		
		Appointment appointment = new Appointment();
		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(appointmentTime);
		appointment.setReason("I have a problem");
		appointment.setStarted(true);
		
		appointment.setPatient(patientRepository.findById(1L).get());
		appointment.setDoctor(doctorRepository.findById(1L).get());
		
		appointmentRepository.save(appointment);
		
	}
	
}
