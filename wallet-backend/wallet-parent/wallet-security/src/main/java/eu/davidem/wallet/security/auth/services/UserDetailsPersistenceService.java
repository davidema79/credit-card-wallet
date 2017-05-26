package eu.davidem.wallet.security.auth.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import eu.davidem.wallet.persistence.entities.User;
import eu.davidem.wallet.persistence.repos.UsersRepository;
import eu.davidem.wallet.security.auth.WalletUserDetails;

/**
 * User Persistence service that support authentication process.
 * 
 * @author Davide Martorana
 *
 */
@Service
public class UserDetailsPersistenceService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsPersistenceService.class);
	
	
	@Autowired
	private UsersRepository repository;
	
	public UserDetails findUserDetailsByUsername(final String username) {
		final Optional<User> userOptional = this.repository.findOneByUsername(username);
		
		final User user = userOptional.orElseThrow(()-> new UsernameNotFoundException(String.format("User '%s' not found.", username)));
		LOGGER.debug("Retieved user '{}' with autority '{}'", user.getUsername(), user.getRole());
		
		final List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		return new WalletUserDetails(user.getId(), username, user.getPassword(), authorities);
	}
	
}
