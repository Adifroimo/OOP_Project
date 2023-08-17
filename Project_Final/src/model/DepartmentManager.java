package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import utils.Gender;
/**@author adifroimovich 318173879 */
public class DepartmentManager extends Employee implements Serializable{
	
	private LocalDateTime appointmentDate;
	private double bonus;

	public DepartmentManager(String iD, String firstName, String lastName, String phoneNumber, Gender gender,int yearOfBirth,
			LocalDateTime dateOfStartWork , double salary, Department dep, LocalDateTime appointmentDate, double bonus,String pass) {
		super(iD, firstName, lastName, phoneNumber, gender, dateOfStartWork, salary, dep, yearOfBirth,getPassword());
		this.appointmentDate = appointmentDate;
		this.bonus = bonus;
	}
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return super.toString()+" , bonus=" + bonus;
	}
	
	

}
