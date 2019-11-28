package com.vertigo.sofrimento_part3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vertigo.sofrimento_part3.model.Employee;
import com.vertigo.sofrimento_part3.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public boolean insereEmployee(Employee employee) { 
		try {
			employeeRepository.save(employee);	
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	 
//CONSERTAR ESSA DESGRAÇAAAAAAAAAA
	public boolean removeEmployee(int id) {
		employeeRepository.delete(buscaPorID(id));
		return true;
	}
	
	public List<Employee> buscaEmployees(){		
		return employeeRepository.findAll();
	}
	
	public Employee buscaPorID(int id) {
		return employeeRepository.findById(id);
	}
	
	public List<Employee> buscaPorNome(String first_name) {
		return employeeRepository.findByFirstname(first_name);
	}
	
	public List<Employee> buscaPorDepartamento(String department){
		return employeeRepository.findByDepartment(department);
	}
	
	
	public List<Employee> buscaPorFuncao(String job_title){ 
		return employeeRepository.findByJobTitle(job_title); 
	}
	 

}
