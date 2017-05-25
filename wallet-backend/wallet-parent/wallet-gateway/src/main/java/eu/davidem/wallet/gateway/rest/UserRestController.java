package eu.davidem.wallet.gateway.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.davidem.wallet.gateway.rest.to.SignUpUser;
import eu.davidem.wallet.persistence.entities.User;
import eu.davidem.wallet.services.UserPersistenceService;

/**
 * Rest Controller for user-wide operations
 * 
 * @author Davide Martorana
 *
 */
@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	private UserPersistenceService persistenceService;
	
	@PostMapping("signup")
	public SignUpUser addUser(@RequestBody final SignUpUser signupUser) {
		final User user = this.persistenceService.addUser(signupUser.getUsername(), signupUser.getPassword());
		
		return new SignUpUser(user.getUsername());
	}
	
	@GetMapping 
	public void test() {
		throw new IllegalArgumentException("Error Test");
	}
	
}
