package model;

import java.util.HashSet;
/**harmonic mean using to calculate to mean pollution of the Deal */

public class HarmonicMean implements ScoreCalculator {

	@Override
	public float calculate(HashSet<VehicleTransportation> allVehicleTransportation) {
		float sum =0;
		for(VehicleTransportation vehi : allVehicleTransportation) {
			sum+=(float)(1)/vehi.getPollutionLevel();
		}
		return allVehicleTransportation.size()/sum;
	}

}
