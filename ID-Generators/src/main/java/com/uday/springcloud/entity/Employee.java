package com.uday.springcloud.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

@Entity
public class Employee {
	
//	@TableGenerator(name = "employee_gen", table="id_gen" , pkColumnName = "gen_name" , valueColumnName = "gen_value", allocationSize = 100)
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
	
	@Id
	@GenericGenerator(name = "emp_id" , strategy = "com.uday.springcloud.random.CustomRandomIdGenerator")
	@GeneratedValue(generator = "emp_id")
	private Long id;
	private String name;
	
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

}
