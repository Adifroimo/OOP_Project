package Exceptions;

public class PersonNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonNotExistException(){
		super("The person does not exist in the System:");
	}  

}
