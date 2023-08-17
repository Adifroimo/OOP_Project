package model;

import java.util.HashSet;

public interface ScoreCalculator {
	public float calculate (HashSet<VehicleTransportation> allVehicleTransportation);
}
