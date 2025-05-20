package com.uday.springcloud.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<PhoneNumber> numbers;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<PhoneNumber> getNumbers() {
		return numbers;
	}
	public void setNumbers(Set<PhoneNumber> numbers) {
		this.numbers = numbers;
	}
	
	//New Method Added
	public void addPhoneNumber(PhoneNumber number) {
		
		if(number != null) {
			if(numbers == null) {
				numbers = new HashSet<>();
			}
			number.setCustomer(this);
			numbers.add(number);
		}
	}
	
}
