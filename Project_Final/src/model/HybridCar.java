package model;

import java.io.Serializable;

import utils.Color;
import utils.MyFileLogWriter;

public class HybridCar extends Car implements Hybrid,Serializable{
private double batteryCapacity;

public HybridCar(double price, double costOfManufacturing, Color color, int yearOfManufacture, double engineCapacity,
		int pollutionLevel, int numberOfSeats, boolean isConvertible) {
	super(price, costOfManufacturing, color, yearOfManufacture, engineCapacity, pollutionLevel, numberOfSeats,
			isConvertible);
	setHybridProperty();
}

public double getBatteryCapacity() {
	return batteryCapacity;
}

public void setBatteryCapacity(double batteryCapacity) {
	this.batteryCapacity = batteryCapacity;
}


@Override
public void describeSpecialProperties() {
	// TODO Auto-generated method stub
	MyFileLogWriter.println("battery capacity<"+ batteryCapacity+">");

}

@Override
public double setHybridProperty() {
	// TODO Auto-generated method stub
	batteryCapacity= getEngineCapacity()*2.5;
	return batteryCapacity;
}
 
}
