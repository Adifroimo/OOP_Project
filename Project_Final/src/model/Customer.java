package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;

import utils.Area;
import utils.Gender;

public class Customer extends Person implements Serializable{
	/**@author adifroimovich 318173879 
	 * customer is the son of person!*/
	private Area area;
	private HashSet<Deal> allDeals;
	private LocalDateTime dateOfJoining;
	

	public Customer(String iD, String firstName, String lastName, String phoneNumber, Gender gender, int yearOfBirth,
			Area area,  LocalDateTime dateOfJoining) {
		super(iD, firstName, lastName, phoneNumber, gender, yearOfBirth);
		this.area = area;
		this.allDeals = new HashSet<>();
		this.dateOfJoining = dateOfJoining;
	}


	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}



	public HashSet<Deal> getAllDeals() {
		return allDeals;
	}

	public void setAllDeals(HashSet<Deal> allDeals) {
		this.allDeals = allDeals;
	}

	public LocalDateTime getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDateTime dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return super.toString()+", dateOfJoining= " + dateOfJoining ;
	}
	
	
	
	

}
