package eu.davidem.wallet.gateway.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import eu.davidem.wallet.exceptions.ResourceNotFoundException;
import eu.davidem.wallet.persistence.exceptions.UsernameAlredyExistsException;

/**
 * Global Error handler
 * 
 * @author Davide Martorana
 *
 */
@RestControllerAdvice
public class GlobalErrorHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalErrorHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handlerForIllegalArgument(final IllegalArgumentException ex) {
		return ex.getMessage();
	}
	
	
	@ExceptionHandler(UsernameAlredyExistsException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handlerForUsernameAlredyExists(final UsernameAlredyExistsException ex) {
		return ex.getMessage();
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handlerForResourceNotFoundException(final ResourceNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public String handlerForAccessDeniedException(final AccessDeniedException ex) {
		return ex.getMessage();
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handlerForGenericRuntimeException(final RuntimeException ex) {
		LOGGER.error("GenericRuntimeException:", ex);
		return ex.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handlerForGenericException(final Exception ex) {
		LOGGER.error("Exception:", ex);
		return "Internal Error";
	}
	
	
}
