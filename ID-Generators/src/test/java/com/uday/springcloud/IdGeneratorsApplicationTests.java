package com.uday.springcloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uday.springcloud.entity.Employee;
import com.uday.springcloud.repository.EmployeeRepository;

@SpringBootTest
class IdGeneratorsApplicationTests {
	
	@Autowired
	EmployeeRepository repo;

	@Test
	public void testCreateEmployee() {
		
		Employee employee = new Employee();
		employee.setName("uday");
		
		repo.save(employee);
	}

}
