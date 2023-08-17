package Exceptions;

public class IncorrectNumberOfSeats  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IncorrectNumberOfSeats(String id){
		super("The number of seats in car / hybrid car can be a maximum of 7. "
				+ "The vehicle < "+id+ "> not added to the system.");
	} 

}
