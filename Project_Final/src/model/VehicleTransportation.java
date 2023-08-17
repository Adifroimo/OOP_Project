package model;


import java.io.Serializable;

import utils.Color;
/**Constructor of the Factory Vechiles - abstract class
 * @author adifroimovich 318173879
 *@param price is the price of thr car
 *@param costOfManufacturing how much the car costed to the Factory
 *@param color of the car
 *@param yearOfManufacture 
 *@param engineCapacity can be upgreded by the method upgrade */
/**@author adifroimovich 318173879 */
/**VehicleTransportation implements Comparable by his licensePlate! */
public abstract class VehicleTransportation implements Comparable<VehicleTransportation>,Serializable {
	
	private static int counter=0;
	private String licensePlate;
	private double price;
	private double costOfManufacturing;
	private Color color;
	private int yearOfManufacture; 
	private double engineCapacity;
	private int pollutionLevel;
	public VehicleTransportation(double price, double costOfManufacturing, Color color,
			int yearOfManufacture, double engineCapacity, int pollutionLevel1) {
		this.price = price;
		this.costOfManufacturing = costOfManufacturing;
		this.color = color;
		this.yearOfManufacture = yearOfManufacture;
		this.engineCapacity = engineCapacity;
		this.pollutionLevel=pollutionLevel1;
		setCounter(getCounter()+1);
	}
	public int compareTo(VehicleTransportation o) {
		return this.licensePlate.compareTo(o.getLicensePlate());
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		VehicleTransportation.counter = counter;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCostOfManufacturing() {
		return costOfManufacturing;
	}
	public void setCostOfManufacturing(double costOfManufacturing) {
		this.costOfManufacturing = costOfManufacturing;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getYearOfManufacture() {
		return yearOfManufacture;
	}
	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}
	public double getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(double engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public int getPollutionLevel() {
		return pollutionLevel;
	}
	public void setPollutionLevel(int pollutionLevel) {
		this.pollutionLevel = pollutionLevel;
	}
	@Override
	public String toString() {
		return "licensePlate= " + licensePlate + ", price= " + price  + ", yearOfManufacture= " + yearOfManufacture
				+ ", engineCapacity= " + engineCapacity ;
	}
	
	abstract public void describeSpecialProperties();
	
}
