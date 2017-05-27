package eu.davidem.wallet.persistence.exceptions;

/**
 * Exception to use if the username alredy exists in the database
 * 
 * @author Davide Martorana
 *
 */
public class UsernameAlredyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5673842100264184925L;

	public UsernameAlredyExistsException() {
		super();
	}

	public UsernameAlredyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameAlredyExistsException(String message) {
		super(message);
	}

	public UsernameAlredyExistsException(Throwable cause) {
		super(cause);
	}

	
	
}
