package eu.davidem.wallet.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import eu.davidem.wallet.persistence.entities.Role;
import eu.davidem.wallet.persistence.entities.User;
import eu.davidem.wallet.persistence.exceptions.UsernameAlredyExistsException;
import eu.davidem.wallet.persistence.repos.UsersRepository;

/**
 * Persistence Service for Users
 * 
 * @author Davide Martorana
 *
 */
@Service
public class UserPersistenceService {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserPersistenceService.class);

	@Autowired
	private UsersRepository userRespository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Add a new user in the System. The given password is encrypted and then
	 * persisted.
	 * 
	 * @param username
	 *            - username provided
	 * @param password
	 *            - password provided
	 * @return the persisted {@link User}
	 */
	public User addUser(final String username, final String password) {
		final User user = new User();
		user.setUsername(username);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setRole(Role.USER);

		try {
			return this.userRespository.saveAndFlush(user);
		} catch (final DataIntegrityViolationException e) {
			LOGGER.info("Username '{}' already in the database.", username);
			throw new UsernameAlredyExistsException("Username exits. Please, choose another one.", e);
		}
	}
}
