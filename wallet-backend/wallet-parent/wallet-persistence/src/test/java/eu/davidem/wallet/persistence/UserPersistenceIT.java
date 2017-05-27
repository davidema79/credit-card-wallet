package eu.davidem.wallet.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.davidem.wallet.persistence.entities.Role;
import eu.davidem.wallet.persistence.entities.User;
import eu.davidem.wallet.persistence.repos.UsersRepository;

/**
 * Integration tests over the users domain
 * 
 * @author Davide Martorana
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@ContextConfiguration(classes={UserPersistenceIT.Config.class})
public class UserPersistenceIT {

	@EnableJpaRepositories(basePackageClasses = { UsersRepository.class })
	public static class Config {
		
	}
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UsersRepository repository;

	
	 @Test
	    public void testFindOneByUsername() throws Exception {
	        this.entityManager.persist(new User(Role.USER, "sboot", "1234"));
	        
	        final Optional<User> userOptional = this.repository.findOneByUsername("sboot");
	        assertThat(userOptional.isPresent()).isTrue();
	        
	        final User user = userOptional.get();	        
	        assertThat(user.getUsername()).isEqualTo("sboot");
	        assertThat(user.getPassword()).isEqualTo("1234");
	    }
	
}
