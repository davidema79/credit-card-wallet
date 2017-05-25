package eu.davidem.wallet.gateway.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import eu.davidem.wallet.persistence.exceptions.UsernameAlredyExists;

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
	public String IllegalArgumentExHandler(final IllegalArgumentException ex) {
		return ex.getMessage();
	}
	
	
	@ExceptionHandler(UsernameAlredyExists.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String UsernameAlredyExists(final UsernameAlredyExists ex) {
		return ex.getMessage();
	}
	

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String GenericRuntimeException(final RuntimeException ex) {
		LOGGER.error("GenericRuntimeException:", ex);
		return ex.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String GenericException(final Exception ex) {
		LOGGER.error("Exception:", ex);
		return "Internal Error";
	}
	
}
