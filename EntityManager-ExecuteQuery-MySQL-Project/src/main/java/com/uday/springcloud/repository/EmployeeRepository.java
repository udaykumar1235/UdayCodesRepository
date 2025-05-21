package com.uday.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.springcloud.Entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
