package com.uday.springcloud.repos;

import org.springframework.data.repository.CrudRepository;

import com.uday.springcloud.entites.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
