package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import utils.Gender;

public class Employee extends Person implements Serializable{
	
	private LocalDateTime dateOfStartWork;
	private double salary;
	private Department dep;
	protected static String password;

	public Employee(String iD, String firstName, String lastName, String phoneNumber, Gender gender,
			LocalDateTime dateOfStartWork, double salary, Department dep, int yearOfBirth,String pass) {
		super(iD, firstName, lastName, phoneNumber, gender,yearOfBirth);
		this.dateOfStartWork = dateOfStartWork;
		this.salary = salary;
		this.dep = dep;
		this.password=pass;
	}

	public static String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getDateOfStartWork() {
		return dateOfStartWork;
	}
	public void setDateOfStartWork(LocalDateTime dateOfStartWork) {
		this.dateOfStartWork = dateOfStartWork;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDep() {
		return dep;
	}
	public void setDep(Department dep) {
		this.dep = dep;
	} 
	@Override
	public String toString() {
		return super.toString() + ", salary= " + salary  +" Department= " +getDep().getDepartmentID();
	}

	
	
	
	

}
