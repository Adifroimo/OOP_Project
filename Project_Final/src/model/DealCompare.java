package model;

import java.util.Comparator;
/**DealCompare is a comparator for methond number 38 */
public class DealCompare implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		if(o1.getAllDeals().size()==o2.getAllDeals().size()){
			int size1=0,size2=0;
			for(Deal deal :o1.getAllDeals()) {
				size1=deal.getAllVehicleTransportation().size();
			}
			for(Deal deal :o2.getAllDeals()) {
				size2=deal.getAllVehicleTransportation().size();
			}
			if(size1>size2) {
				return -1;
			}
			if(size2>size1) {
				return 1;
			}
			return o1.compareTo(o2);
			}
		if(o1.getAllDeals().size()>o2.getAllDeals().size()) {
			return 1;
		}
		return -1;
	}
	

}
