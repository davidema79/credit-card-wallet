package eu.davidem.wallet.exceptions;

/**
 * Throw this exception when a resource expected to be found, was not found.
 * 
 * @author Davide Martorana
 *
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2574092272255765762L;

	
	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}	
	
}
