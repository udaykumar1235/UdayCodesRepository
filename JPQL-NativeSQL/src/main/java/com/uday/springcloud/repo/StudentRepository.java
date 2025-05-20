package com.uday.springcloud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uday.springcloud.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	@Query("from Student")
	List<Student> findAllStudents();

	@Query("select st.fname, st.lname from Student st")
	List<Object[]> findAllStudentsPartialData();
	
	@Query("from Student where fname =:firstName")
	List<Student> findAllStudentsFirstName(@Param("firstName") String firstName);
	
	@Query("from Student where score >:min and score <:max")
	List<Student> findStudentsGivenScores(@Param("min") int min ,@Param("max") int max);
	
	@Modifying
	@Query("delete from Student where fname =:firstName")
	void deleteStudentByFirstName(@Param("firstName") String firstName);
	
	//Native Queries
	@Query(value = "select * from student" , nativeQuery = true)
	List<Student> findAllStudentNQ();
	
	@Query(value = "select * from student where fname =:firstName" , nativeQuery = true)
	List<Student> findByStudentFirstNameNQ(@Param("firstName") String firstName);
}
