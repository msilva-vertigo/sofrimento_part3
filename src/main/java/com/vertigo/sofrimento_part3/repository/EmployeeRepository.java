package com.vertigo.sofrimento_part3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vertigo.sofrimento_part3.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findById(int id);
	
	void deleteById(Integer id);
	
	@Query(value = "SELECT * FROM employees WHERE first_name = ?1", nativeQuery = true)
	List<Employee> findByFirstname(String first_name);
	
	List<Employee> findByDepartment(String department);
	
	@Query(value = "SELECT * FROM employees WHERE job_title = ?1", nativeQuery = true)
	List<Employee> findByJobTitle(String job_title);

}