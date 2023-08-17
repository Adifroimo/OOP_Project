package model;

import java.util.Comparator;
/** ComparePollution is a comparator for method number 37*/
public class ComparePollution implements Comparator<VehicleTransportation> {

	@Override
	public int compare(VehicleTransportation o1, VehicleTransportation o2) {
		if(o1.getPollutionLevel()==o2.getPollutionLevel()) {
			if(o1.getPrice()>o2.getPrice()) {
			return 1;
			}else {
				if(o1.getPrice()<o2.getPrice()) {
					return -1;
				}
				return o1.compareTo(o2);
			}
		}
		if(o1.getPollutionLevel()>o2.getPollutionLevel()) {
			return -1;
		}
		return 1;
	}

}
