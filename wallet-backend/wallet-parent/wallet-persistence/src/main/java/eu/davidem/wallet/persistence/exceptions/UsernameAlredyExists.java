package eu.davidem.wallet.persistence.exceptions;

/**
 * Exception to use if the username alredy exists in the database
 * 
 * @author Davide Martorana
 *
 */
public class UsernameAlredyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5673842100264184925L;

	public UsernameAlredyExists() {
		super();
	}

	public UsernameAlredyExists(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameAlredyExists(String message) {
		super(message);
	}

	public UsernameAlredyExists(Throwable cause) {
		super(cause);
	}

	
	
}
