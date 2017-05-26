package eu.davidem.wallet.persistence.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import eu.davidem.wallet.persistence.entities.CreditCard;

/**
 * 
 * @author Davide Martorana
 *
 */
@Transactional
public interface CreditCardsRepository extends JpaRepository<CreditCard, Long> {

	List<CreditCard> findAllByUserId(final long userId);
	
	List<CreditCard> findAllByIdAndUserId(final long id, final long userId);
	
	Optional<CreditCard> findOneByCardNumber(final String cardNumber);
	
}
