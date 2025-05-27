package com.uday.springcloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uday.springcloud.Entities.Customer;
import com.uday.springcloud.Entities.CustomerId;
import com.uday.springcloud.repository.CustomerRepository;

@SpringBootTest
class CompositePrimarykeysExampleApplicationTests {
	
	@Autowired
	CustomerRepository repo;

	@Test
	public void testSaveCustomer() {
	
		Customer customer = new Customer();
		CustomerId id = new CustomerId();
		
		id.setId(1234);
		id.setEmail("uday@gmail.com");
		
		customer.setId(id);
		customer.setName("uday customer");
		repo.save(customer);
		
	}
	

}
