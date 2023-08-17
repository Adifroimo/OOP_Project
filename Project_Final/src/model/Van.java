package model;

import java.io.Serializable;

import utils.Color;
import utils.MyFileLogWriter;
/**@author adifroimovich 318173879
 * in this constructor we used the static integer counter- who runs with licensePlate, and added the letter v because this is a van! */
public class Van extends VehicleTransportation implements Upgrade,Serializable{
	
	private double trunkSize;
	private double maxWeightCarrying;
	
	public Van(double price, double costOfManufacturing, Color color, int yearOfManufacture, double engineCapacity,
			int pollutionLevel, double trunkSize, double maxWeightCarrying) {
		super(price, costOfManufacturing, color, yearOfManufacture, engineCapacity, pollutionLevel);
		this.trunkSize = trunkSize;
		this.maxWeightCarrying = maxWeightCarrying;
		setLicensePlate("v" +getCounter());
	}

	public double getTrunkSize() {
		return trunkSize;
	}

	public void setTrunkSize(double trunkSize) {
		this.trunkSize = trunkSize;
	}

	public double getMaxWeightCarrying() {
		return maxWeightCarrying;
	}

	public void setMaxWeightCarrying(double maxWeightCarrying) {
		this.maxWeightCarrying = maxWeightCarrying;
	}

	@Override
	public String toString() {
		return super.toString()+" trunkSize= " + trunkSize;
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		setEngineCapacity(getEngineCapacity()*(1.2));
	}

	@Override
	public void describeSpecialProperties() {
		// TODO Auto-generated method stub
		MyFileLogWriter.println("trunk size <"+ trunkSize+" > max weight carrying <"+ maxWeightCarrying+"> " );

	}
	 
	

}
