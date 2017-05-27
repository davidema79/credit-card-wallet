package eu.davidem.wallet.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.davidem.wallet.persistence.entities.CreditCard;
import eu.davidem.wallet.persistence.entities.Role;
import eu.davidem.wallet.persistence.entities.User;
import eu.davidem.wallet.persistence.repos.CreditCardsRepository;
import eu.davidem.wallet.persistence.repos.UsersRepository;

/**
 * Integration tests over the credit cards domain
 * 
 * @author Davide Martorana
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@ContextConfiguration(classes = { CreditCardPersistenceIT.Config.class })
public class CreditCardPersistenceIT {

	@EnableJpaRepositories(basePackageClasses = { CreditCardsRepository.class, UsersRepository.class, CreditCard.class, User.class})
	public static class Config {

	}

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CreditCardsRepository repository;
	
	@Test
	public void testFindAllByUserId() throws Exception {
		final User userFirst = this.entityManager.persist(new User(Role.USER, "first", "password"));
		final User userSecond =  this.entityManager.persist(new User(Role.USER, "second", "password"));

		final long userFirstId = userFirst.getId();
		final long userSecondId = userSecond.getId();

		this.entityManager.persist(this.createCreditCard(userFirstId, "Davide Martorana", "411111111111111", 10, 18));
		this.entityManager.persist(this.createCreditCard(userFirstId, "Josephine Martorana", "421111111111112", 5, 25));
		this.entityManager.persist(this.createCreditCard(userFirstId, "Joseph Martorana", "431111111111113", 1, 20));
		
		this.entityManager.persist(this.createCreditCard(userSecondId, "Joseph Borg", "531111111111113", 11, 21));
		this.entityManager.persist(this.createCreditCard(userSecondId, "Josephine Borg", "541111111111114", 12, 19));
		
		final List<CreditCard> listFirst = this.repository.findAllByUserId(userFirstId);		
		assertThat(listFirst).isNotEmpty();
		assertThat(listFirst.size()).isEqualTo(3);
		
		final List<CreditCard> listSecond = this.repository.findAllByUserId(userSecondId);		
		assertThat(listSecond).isNotEmpty();
		assertThat(listSecond.size()).isEqualTo(2);
		
		
	}
	
	@Test
	public void testFindAllByIdAndUserId() throws Exception {
		final User userFirst = this.entityManager.persist(new User(Role.USER, "first", "password"));
		final User userSecond =  this.entityManager.persist(new User(Role.USER, "second", "password"));

		final long userFirstId = userFirst.getId();
		final long userSecondId = userSecond.getId();
		
		final CreditCard cc1 = this.entityManager.persist(this.createCreditCard(userFirstId, "Davide Martorana", "411111111111111", 10, 18));
		final CreditCard cc2 = this.entityManager.persist(this.createCreditCard(userFirstId, "Josephine Martorana", "421111111111112", 5, 25));
		final CreditCard cc3 = this.entityManager.persist(this.createCreditCard(userFirstId, "Joseph Martorana", "431111111111113", 1, 20));
		
		final CreditCard cc4 = this.entityManager.persist(this.createCreditCard(userSecondId, "Joseph Borg", "531111111111113", 11, 21));
		final CreditCard cc5 = this.entityManager.persist(this.createCreditCard(userSecondId, "Josephine Borg", "541111111111114", 12, 19));
		
		final List<CreditCard> listFirst = this.repository.findAllByIdAndUserId(cc1.getId().longValue(), userFirstId);		
		assertThat(listFirst).isNotEmpty();
		assertThat(listFirst.size()).isEqualTo(1);
		
		assertThat(this.repository.findAllByIdAndUserId(cc1.getId(), userSecondId)).isEmpty();
		assertThat(this.repository.findAllByIdAndUserId(cc2.getId(), userSecondId)).isEmpty();
		assertThat(this.repository.findAllByIdAndUserId(cc3.getId(), userSecondId)).isEmpty();
		
		assertThat(this.repository.findAllByIdAndUserId(cc4.getId(), userFirstId)).isEmpty();
		assertThat(this.repository.findAllByIdAndUserId(cc5.getId(), userFirstId)).isEmpty();
		
	}
	
	
	@Test
	public void testFindAllLikeWitnNumber() throws Exception {
		final User userFirst = this.entityManager.persist(new User(Role.USER, "first", "password"));
		final User userSecond =  this.entityManager.persist(new User(Role.USER, "second", "password"));

		final long userFirstId = userFirst.getId();
		final long userSecondId = userSecond.getId();
		
		this.entityManager.persist(this.createCreditCard(userFirstId, "Davide Martorana", "411111111111111", 10, 18));
		this.entityManager.persist(this.createCreditCard(userFirstId, "Josephine Martorana", "412111111111112", 5, 25));
		this.entityManager.persist(this.createCreditCard(userFirstId, "Joseph Martorana", "411111111111113", 1, 20));
		
		this.entityManager.persist(this.createCreditCard(userSecondId, "Joseph Borg", "531111111111113", 11, 21));
		this.entityManager.persist(this.createCreditCard(userSecondId, "Josephine Borg", "561111111111114", 12, 19));
		
		final List<CreditCard> listFirst = this.repository.findAllLikeWitnNumber("41", userFirstId);		
		assertThat(listFirst.size()).isEqualTo(3);
		
		assertThat(this.repository.findAllLikeWitnNumber("1111111", userSecondId).size()).isEqualTo(2);
		assertThat(this.repository.findAllLikeWitnNumber("5", userSecondId).size()).isEqualTo(2);
		assertThat(this.repository.findAllLikeWitnNumber("41", userSecondId)).isEmpty();
	}
	
	
	private CreditCard createCreditCard(final long userId, final String nameHolder, final String cardNumber, final int dateExpMonth, final int dateExpYear) {
		final CreditCard cc = new CreditCard();
		cc.setCardNumber(cardNumber);
		cc.setDateExpMonth(dateExpMonth);
		cc.setDateExpYear(dateExpYear);
		cc.setNameHolder(nameHolder);
		cc.setUserId(userId);
		
		return cc;
	}
}
