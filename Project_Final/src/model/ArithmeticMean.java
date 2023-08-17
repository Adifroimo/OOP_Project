package model;

import java.util.HashSet;
/**harmonic mean using to calculate to mean pollution of the Deal */
public class ArithmeticMean implements ScoreCalculator {

	@Override
	public float calculate(HashSet<VehicleTransportation> allVehicleTransportation) {
		float sum=0;
		for(VehicleTransportation vehi : allVehicleTransportation) {
			sum+=vehi.getPollutionLevel();
			
		}
		return (sum/allVehicleTransportation.size());
	}
	
}
