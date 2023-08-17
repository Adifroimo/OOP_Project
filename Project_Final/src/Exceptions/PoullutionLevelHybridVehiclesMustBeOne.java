package Exceptions;

public class PoullutionLevelHybridVehiclesMustBeOne extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PoullutionLevelHybridVehiclesMustBeOne(String id){
		super("“Pollution level in hybrid vehicles must be 1. The vehicle"
	+"<"+id+">not added to the system.");
	}  

} 

