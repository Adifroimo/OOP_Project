package Exceptions;

public class PersonAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PersonAlreadyExistException(String first,String last){
		super("The person already exists in the System:<"+first+last+">"+"The person already exists in the System:");
	}

}
