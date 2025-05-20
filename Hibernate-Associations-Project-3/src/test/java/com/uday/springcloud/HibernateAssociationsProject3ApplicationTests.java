package com.uday.springcloud;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uday.springcloud.oneToOne.Entities.License;
import com.uday.springcloud.oneToOne.Entities.Person;
import com.uday.springcloud.oneToOne.repository.LicenseRepository;

@SpringBootTest
class HibernateAssociationsProject3ApplicationTests {
	
	@Autowired
	LicenseRepository repo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateLicense() {
		
		License license = new License();
		license.setType("Kite");
		license.setValidForm(new Date());
		license.setValidTo(new Date());
		
		Person person = new Person();
		person.setFirstName("Kiran");
		person.setLastName("Fun");
		person.setAge(30);
		
		license.setPerson(person);
		repo.save(license);
	}

}
