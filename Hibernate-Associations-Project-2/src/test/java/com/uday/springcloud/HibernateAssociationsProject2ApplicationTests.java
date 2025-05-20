package com.uday.springcloud;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.uday.springcloud.manyToMany.Entities.Programmer;
import com.uday.springcloud.manyToMany.Entities.Project;
import com.uday.springcloud.manyToMany.repository.ProgrammerRepository;

@SpringBootTest
class HibernateAssociationsProject2ApplicationTests {
	
	@Autowired
	ProgrammerRepository repo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void createTestProgrammer() {
		
		Programmer programmer = new Programmer();
		programmer.setName("Uday");
		programmer.setSal(15000);
		
		HashSet<Project> projects = new HashSet<Project>();
		Project project = new Project();
		project.setName("Hibernate Project");
		projects.add(project);
		
		programmer.setProjects(projects);
		
		repo.save(programmer);
	}
	
	@Test
	@Transactional
	public void testFindProgrammer() {
		
		Programmer programmer = repo.findById(1).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}
	
}
