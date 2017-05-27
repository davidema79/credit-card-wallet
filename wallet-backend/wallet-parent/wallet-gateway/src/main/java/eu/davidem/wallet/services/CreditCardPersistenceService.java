package eu.davidem.wallet.services;

import java.util.List;

import org.apache.commons.validator.routines.CreditCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import eu.davidem.wallet.persistence.entities.CreditCard;
import eu.davidem.wallet.persistence.repos.CreditCardsRepository;
import eu.davidem.wallet.security.config.SecurityContextHolderUtils;

/**
 * Persistence Service for Credit Card
 * 
 * @author Davide Martorana
 *
 */
@Service
public class CreditCardPersistenceService {

	@Autowired
	private CreditCardsRepository repository;

	private static CreditCardValidator CC_VALIDATOR = new CreditCardValidator();

	/**
	 * Get all the credit cards that belong to the User in the
	 * {@link SecurityContextHolder} (currently logged user)
	 * 
	 * @return a list of Credit Card. The list could be empty, but never
	 *         <code>null</code>.
	 */
	public List<CreditCard> getAll() {
		final long userId = SecurityContextHolderUtils.getCurrentUserId();
		return this.repository.findAllByUserId(userId);
	}

	/**
	 * Searches and returns all the credit cards that belongs to the current
	 * user, and contain the given {@code number}
	 * 
	 * @param number
	 *            - Credit Card Number to search for.
	 * 
	 * @return returns a list of {@link CreditCard}, empty if none was found.
	 */
	public List<CreditCard> getAllWithNumber(final String number) {
		final long userId = SecurityContextHolderUtils.getCurrentUserId();
		return this.repository.findAllLikeWitnNumber(number, userId);
	}

	/**
	 * Returns the Credit Card with the given {@code id}
	 * 
	 * @param id
	 *            - the Credit Card Identifier in the Database
	 * 
	 * @return the Credit Card with the given {@code id}, or null if not found.
	 */
	public CreditCard getOne(final long id) {
		return this.repository.findOne(id);
	}

	/**
	 * Insert a new credit card if the given {@code creditTO} is not in the
	 * system, else update the expiration data.
	 * 
	 * @param creditTO
	 *            - credit card to insert or update
	 * @return a instance of {@link CreditCard} containing the date persisted.
	 */
	public CreditCard save(final eu.davidem.wallet.gateway.rest.to.CreditCard creditTO) {

		if (!CC_VALIDATOR.isValid(creditTO.getCardNumber().trim())) {
			throw new IllegalArgumentException("Credit Card Not Valid: " + creditTO.getCardNumber());
		}

		if (creditTO.getId() == null) {

			// We are adding it now
			final CreditCard newCC = new CreditCard();
			newCC.setCardNumber(creditTO.getCardNumber().trim());
			newCC.setDateExpMonth(creditTO.getDateExpMonth());
			newCC.setDateExpYear(creditTO.getDateExpYear());
			newCC.setNameHolder(creditTO.getNameHolder());
			newCC.setUserId(SecurityContextHolderUtils.getCurrentUserId());

			return this.repository.saveAndFlush(newCC);
		}

		final CreditCard oldCC = this.repository.findOne(creditTO.getId());
		oldCC.setDateExpMonth(creditTO.getDateExpMonth());
		oldCC.setDateExpYear(creditTO.getDateExpYear());

		return this.repository.saveAndFlush(oldCC);

	}

}
