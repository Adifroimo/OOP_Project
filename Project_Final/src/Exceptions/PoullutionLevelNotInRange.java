package Exceptions;

public class PoullutionLevelNotInRange extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PoullutionLevelNotInRange(String id){
		super("Pollution level not in range. The vehicle <"+id+">"+
		"not added to the system.");
	}  

}
