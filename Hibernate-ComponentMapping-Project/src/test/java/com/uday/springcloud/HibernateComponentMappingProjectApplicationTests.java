package com.uday.springcloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uday.springcloud.entites.Address;
import com.uday.springcloud.entites.Employee;
import com.uday.springcloud.repos.EmployeeRepository;

@SpringBootTest
class HibernateComponentMappingProjectApplicationTests {
	
	@Autowired
	private EmployeeRepository repo;

	@Test
	public void testCreateEmployee() {
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Uday");
		
		Address add = new Address();
		add.setStreetaddress("Hyd");
		add.setCity("Vijayawada");
		add.setState("Andrapradesh");
		add.setCountry("India");
		add.setZipcode("12387");
		
		emp.setAddress(add);
		
		repo.save(emp);
	}

	
	
}
