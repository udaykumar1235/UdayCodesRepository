package com.uday.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uday.springcloud.Entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Service
public class EmployeeService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Employee> getEmployeesByDepartment(String department){
				
		return entityManager.createQuery("SELECT e FROM Employee e WHERE e.department=:dept", Employee.class)
				.setParameter("dept", department)
				.getResultList();
	}	
	
	public List<Employee> getHighSalaryEmployees(double minSalary){
		
		return entityManager.createNativeQuery("SELECT * FROM Employee WHERE salary > ?", Employee.class)
				.setParameter(1, minSalary)
				.getResultList();
	}

	@Transactional
	public int updateEmployeeDepartment(Long id, String newDepartment) {
		
		return entityManager.createQuery("UPDATE Employee e SET e.department=:dept WHERE e.id=:id")
				.setParameter("dept", newDepartment)
				.setParameter("id", id)
				.executeUpdate();
	}
	
	@Transactional
	public int deleteByDepartment(String department) {
		
		return entityManager.createQuery("DELETE FROM Employee e WHERE e.department=:dept")
				.setParameter("dept", department)
				.executeUpdate();
	}
	
	public List<Employee> getPaginatedEmployees(int page, int size){
		
		return entityManager.createQuery("SELECT e FROM Employee e ORDER BY e.id", Employee.class)
				.setFirstResult(page * size)
				.setMaxResults(size)
				.getResultList();
	}
	
	
	public Double getAverageSalary() {
		
		return entityManager.createQuery("SELECT AVG(e.salary) FROM Employee e", Double.class)
				.getSingleResult();
	}
	
	@Transactional
	public Employee save(Employee e) {
		
		entityManager.persist(e);
		return e;
	}
	

}
