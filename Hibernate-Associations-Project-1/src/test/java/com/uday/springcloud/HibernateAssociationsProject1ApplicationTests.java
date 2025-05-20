package com.uday.springcloud;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.uday.springcloud.entities.Customer;
import com.uday.springcloud.entities.PhoneNumber;
import com.uday.springcloud.repository.CustomerRepository;

@SpringBootTest
class HibernateAssociationsProject1ApplicationTests {
	
	@Autowired
	private CustomerRepository repo;
	private Customer customer;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateWithoutMethodUsedCustomer() {
		
		Customer customer = new Customer();
		customer.setName("Uday");
		HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("123456332");
		ph1.setType("cell");
		ph1.setCustomer(customer);
	    numbers.add(ph1);
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("3456332998");
		ph2.setType("mobile");
		ph2.setCustomer(customer);
		numbers.add(ph2);
		
		customer.setNumbers(numbers);
		
		repo.save(customer);
	}

	@Test
	public void testCreateModifiedNewMethodUsedCustomer() {
		
		Customer customer = new Customer();
		customer.setName("Uday Kumar");
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("123456332");
		ph1.setType("cell");
	
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("3456332998");
		ph2.setType("mobile");
		
		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);
	
		repo.save(customer);
	}
	
	@Test
	@Transactional
	public void testLoadCustomer() {
		
		Customer customer = repo.findById(152L).get();
		System.out.println(customer.getName());
		
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number -> System.out.println(number.getNumber()));
	}
	
	@Test
	public void testUpdateLoadCustomer() {
		
		Customer customer = repo.findById(152L).get();
		customer.setName("Uday Reddy");
		
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number -> number.setType("Cake"));
		
		repo.save(customer);
	}
	
	@Test
	public void testDelete() {
		
		repo.deleteById(152L);
	}
	
	
	
	
	
	
	
	
	
	
}
