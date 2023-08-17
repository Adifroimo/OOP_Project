package model;

import java.io.Serializable;
import java.util.HashSet;

import utils.Specialization;
/**@author adifroimovich 318173879 */
public class Department implements Serializable {
	private Integer departmentID;
	private Specialization specialization;
	private DepartmentManager depManager;
	private HashSet<Employee> allEmployees;
	public Department(int departmentID, Specialization specialization) {
		super();
		this.departmentID = departmentID;
		this.specialization = specialization;
		allEmployees = new HashSet<Employee>();
	}
	
	public Integer getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public DepartmentManager getDepManager() {
		return depManager;
	}
	public void setDepManager(DepartmentManager depManager) {
		this.depManager = depManager;
	}

	public HashSet<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(HashSet<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}

	@Override
	public String toString() {
		return " departmentID= " + departmentID + ", specialization= " + specialization /*+ ", depManager= "
				+ depManager.getFirstName() +" " +depManager.getLastName()*/ ;
	}
	
	
	

}
