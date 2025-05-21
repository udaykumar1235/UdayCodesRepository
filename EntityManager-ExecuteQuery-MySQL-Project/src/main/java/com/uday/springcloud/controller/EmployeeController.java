package com.uday.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uday.springcloud.Entities.Employee;
import com.uday.springcloud.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		return service.save(employee);
	}
	
	@GetMapping("/by-department")
	public List<Employee> getByDepartment(@RequestParam String department){
		
		return service.getEmployeesByDepartment(department);
	}
	
	@GetMapping("/high-salary")
	public List<Employee> getHighSalary(@RequestParam double salary){
		
		return service.getHighSalaryEmployees(salary);
	}
	
	@PutMapping("/update-department")
	public String updateDepartment(@RequestParam Long id, @RequestParam String department) {
		
		int updated = service.updateEmployeeDepartment(id, department);
		
		return updated > 0 ? "Updated Successfully":"Update Failed!";
	}
	
	@DeleteMapping("/delete-by-department")
	public String deleteByDepartment(@RequestParam String department) {
		
		int deleted = service.deleteByDepartment(department);
		
		return deleted > 0 ? "Deleted Successfully":"No Records Found!";
	}
	
	@GetMapping("/paginated")
	public List<Employee> getPaginated(@RequestParam int page, @RequestParam int size){
		
		return service.getPaginatedEmployees(page, size);
	}
	
	@GetMapping("/average-salary")
	public Double getAverageSalary() {
		return service.getAverageSalary();
	}
	
	
}
