package com.uday.springcloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.uday.springcloud.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
