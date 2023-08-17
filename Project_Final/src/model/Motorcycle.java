package model;

import java.io.Serializable;

import utils.Color;
import utils.MyFileLogWriter;

/**@author adifroimovich 318173879
 * in this constructor we used the static integer counter- who runs with licensePlate, and added the letter m because this is a motorcycle! */
public class Motorcycle extends VehicleTransportation implements Serializable{
	
	private boolean isOffRoad;

	public Motorcycle(double price, double costOfManufacturing, Color color, int yearOfManufacture,
			double engineCapacity, int pollutionLevel, boolean isOffRoad) {
		super(price, costOfManufacturing, color, yearOfManufacture, engineCapacity, pollutionLevel);
		this.isOffRoad = isOffRoad;
		setLicensePlate("m" +getCounter());
	}

	public boolean isOffRoad() {
		return isOffRoad;
	}

	public void setOffRoad(boolean isOffRoad) {
		this.isOffRoad = isOffRoad;
	}

	@Override
	public String toString() {
		return super.toString()+ " isOffRoad= " + isOffRoad;
	}

	@Override
	public void describeSpecialProperties() {
		// TODO Auto-generated method stub
		MyFileLogWriter.println("is off road <"+ isOffRoad+" >" );

	}


	
	

}
