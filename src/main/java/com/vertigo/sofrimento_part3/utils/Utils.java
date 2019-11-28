package com.vertigo.sofrimento_part3.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vertigo.sofrimento_part3.model.Employee;

public class Utils {
	public static String toJSON(Object obj) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(obj);
	}
	
	public static List<Employee> buscaEmployeesFromResponse(ResponseEntity<List> response, String atributo, String valor) {
		List<Employee> employees = new ArrayList<Employee>();
		
		
		switch (atributo){
			case "department":
				employees = buscaPorDepartamento(response.getBody(), valor);
				break;
			case "nome":
				employees = buscaPorNome(response.getBody(), valor);
				break;
			case "funcao":
				employees = buscaPorFuncao(response.getBody(), valor);
				break;
			case "id":
				employees.add(buscaPorID(response.getBody(), Integer.parseInt(valor)));
				break;
		}
		
		
		
		return employees;
	}
	
	private static Employee buscaPorID(List body, int id) {
		Gson gson = new Gson();
		
		for(int i=0; i<body.size();i++) {
			String json = Utils.toJSON(body.get(i));
			Employee employee = gson.fromJson(json, Employee.class);
			
			if(employee.getEmployee_id()==id) {
				return employee;
			}
		}
		
		return null;
		
	}
	
	private static List<Employee> buscaPorNome(List body, String nome) {
		Gson gson = new Gson();
		List<Employee> employees = new ArrayList<Employee>();
		for(int i=0; i<body.size();i++) {
			String json = Utils.toJSON(body.get(i));
			Employee employee = gson.fromJson(json, Employee.class);
			
			if(employee.getFirst_name().equalsIgnoreCase(nome)) {
				employees.add(employee);
			}
		}
		
		return employees;
		
	}
	
	private static List<Employee> buscaPorFuncao(List body, String funcao) {
		Gson gson = new Gson();
		List<Employee> employees = new ArrayList<Employee>();
		for(int i=0; i<body.size();i++) {
			String json = Utils.toJSON(body.get(i));
			Employee employee = gson.fromJson(json, Employee.class);
			
			if(employee.getJob_title().equalsIgnoreCase(funcao)) {
				employees.add(employee);
			}
		}
		
		return employees;
		
	}
	
	private static List<Employee> buscaPorDepartamento(List body, String departamento) {
		Gson gson = new Gson();
		List<Employee> employees = new ArrayList<Employee>();
		for(int i=0; i<body.size();i++) {
			String json = Utils.toJSON(body.get(i));
			Employee employee = gson.fromJson(json, Employee.class);
			
			if(employee.getDepartment().equalsIgnoreCase(departamento)) {
				employees.add(employee);
			}
		}
		
		return employees;
		
	}
	
}
