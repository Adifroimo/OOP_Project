package Exceptions;

public class YearOfBirthNotInRange extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public YearOfBirthNotInRange(String id){
		super("The person's year of birth must be between 1900-2022. The"
				+ "person <"+id+"> not added to the system.”");
	} 

}
