package com.uday.springcloud;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uday.springcloud.entity.Student;
import com.uday.springcloud.repo.StudentRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class JpqlNativeSqlApplicationTests {
	
	@Autowired
	private StudentRepository repo;

	@Test
	public void testStudentCreate() {
		
		Student student = new Student();
		student.setFname("Uday");
		student.setLname("Kiran");
		student.setScore(1500);
		
		Student std1 = new Student();
		std1.setFname("Ravi");
		std1.setLname("kaki");
		std1.setScore(900);
		
		repo.save(student);
		
		repo.save(std1);
	}

	@Test
	public void testFindAllStudents() {
		
		System.out.println(repo.findAllStudents());
	}
	
	@Test
	public void testFindByParialData() {
		
		List<Object[]> data = repo.findAllStudentsPartialData();
		for(Object[] d1 : data) {
			System.out.println(d1[0]);
			System.out.println(d1[1]);
		}
		
	}
	
	@Test
	public void testFindByAllStudentsFirstName() {
		
		System.out.println(repo.findAllStudentsFirstName("Uday"));
	}
	
	@Test
	public void testFindByStudentsGrades() {
		
		System.out.println(repo.findStudentsGivenScores(800, 1000));
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteByStudentFirstName() {
		
		repo.deleteStudentByFirstName("Uday");
	}
	
	@Test
	public void testFindNativeQuery() {
		System.out.println(repo.findAllStudentNQ());
	}
	
	@Test
	public void testFirstNameNativeQuery() {
		System.out.println(repo.findByStudentFirstNameNQ("Uday"));
	}
}
