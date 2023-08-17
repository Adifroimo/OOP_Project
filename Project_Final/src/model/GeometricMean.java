package model;

import java.util.HashSet;
import java.math.*;
/**harmonic mean using to calculate to mean pollution of the Deal */
public class GeometricMean implements ScoreCalculator{

	@Override
	public float calculate(HashSet<VehicleTransportation> allVehicleTransportation) {
		double pollution=1;
		for(VehicleTransportation vehi : allVehicleTransportation) {
			pollution*=vehi.getPollutionLevel();
		}
		double pow =allVehicleTransportation.size();
		return (float) (Math.pow(pollution, (1/pow)));
	}

}
