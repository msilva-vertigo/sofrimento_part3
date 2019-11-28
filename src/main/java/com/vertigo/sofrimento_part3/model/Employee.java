package com.vertigo.sofrimento_part3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employee_id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="department")
	private String department;
	
	@Column(name="job_title")
	private String job_title;
	
	@Column(name="employee_type")
	private String employee_type;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@Column(name="start_date")
	private Date start_date;
	
	@Column(name="email")
	private String email;
	
	
	
	public Employee() {}
	
	public Employee(int employee_id, String first_name, String last_name, String department, String job_title,
			String employee_type, Date start_date, String email) {
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.department = department;
		this.job_title = job_title;
		this.employee_type = employee_type;
		this.start_date = start_date;
		this.email = email;
	}

	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getEmployee_type() {
		return employee_type;
	}

	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
