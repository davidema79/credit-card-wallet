package eu.davidem.wallet.persistence.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import eu.davidem.wallet.persistence.entities.CreditCard;

/**
 * Repository for the Credit Card.
 * 
 * @author Davide Martorana
 *
 */

@Transactional
public interface CreditCardsRepository extends JpaRepository<CreditCard, Long> {

	List<CreditCard> findAllByUserId(final long userId);

	List<CreditCard> findAllByIdAndUserId(final long id, final long userId);

	@Query(nativeQuery = true, 
			value = "SELECT * " 
					+ " FROM credit_cards c " 
					+ " WHERE user_id= :userId AND "
					+ " card_number LIKE CONCAT('%', :cardNumber, '%')")
	List<CreditCard> findAllLikeWitnNumber(@Param("cardNumber") final String cardNumber, @Param("userId") final long userId);

	Optional<CreditCard> findOneByCardNumber(final String cardNumber);

}
