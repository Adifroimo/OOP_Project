package model;
import java.util.Comparator;
/**BestDealCompare is a comparator for methond number 40, in this comparator we are using constructor to get the wanted 
 * ScoreClaculator to use in this Comparator */
public class BestDealCompare implements Comparator<Deal> {
	ScoreCalculator s;

	
	public BestDealCompare(ScoreCalculator s) {
		super();
		this.s = s;
	}


	public int compare(Deal o1, Deal o2) {
	//	ScoreCalculator scoreCalculator1 = (ScoreCalculator) new Deal(o1.getCustomer(), o1.getDealDate(), o1.getAllVehicleTransportation(),o1.getShippingCost());
	//	ScoreCalculator scoreCalculator2 = (ScoreCalculator) new Deal(o2.getCustomer(), o2.getDealDate(), o2.getAllVehicleTransportation(),o2.getShippingCost());
		if(o1.GetScore(s)>o2.GetScore(s)) {
			return 1;
		}
		if(o1.GetScore(s)<o2.GetScore(s)) {
			return -1;
		}
		return 0;
	}

}
