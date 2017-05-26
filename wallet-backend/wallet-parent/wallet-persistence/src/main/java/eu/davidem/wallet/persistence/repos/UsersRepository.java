package eu.davidem.wallet.persistence.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import eu.davidem.wallet.persistence.entities.User;

/**
 * Repository for the {@link User}
 * 
 * @author Davide Martorana
 *
 */
@Transactional
public interface UsersRepository extends JpaRepository<User, Long>{

	Optional<User> findOneByUsername(final String username);
	
}
