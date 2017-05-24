package eu.davidem.wallet.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import eu.davidem.wallet.persistence.entities.User;

/**
 * 
 * @author Davide Martorana
 *
 */
@Transactional
public interface UsersRepository extends JpaRepository<User, Long>{

	User findOneByUsername(final String username);
	
}
