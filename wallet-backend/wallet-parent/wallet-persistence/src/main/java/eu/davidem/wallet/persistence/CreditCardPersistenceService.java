package eu.davidem.wallet.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.davidem.wallet.persistence.entities.CreditCard;
import eu.davidem.wallet.persistence.repos.CreditCardsRepository;

/**
 * 
 * @author Davide Martorana
 *
 */
@Service
public class CreditCardPersistenceService {

	@Autowired
	private CreditCardsRepository repository;

	/**
	 * Get all the credit cards that belong to the User with the given
	 * {@code id}
	 * 
	 * @param userId
	 *            - ID of the user we want to get the credit cards of.
	 * @return a list of Credit Card. The list could be empty, but never
	 *         <code>null</code>.
	 */
	public List<CreditCard> getAll(final long userId) {
		return this.repository.findAllByUserId(userId);
	}

}
