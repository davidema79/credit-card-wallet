package eu.davidem.wallet.gateway.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.davidem.wallet.exceptions.ResourceNotFoundException;
import eu.davidem.wallet.gateway.rest.to.CreditCard;
import eu.davidem.wallet.gateway.rest.to.CreditCardMapper;
import eu.davidem.wallet.security.config.SecurityContextHolderUtils;
import eu.davidem.wallet.services.CreditCardPersistenceService;

/**
 * REST Controller for Credit Cards operations
 * 
 * @author Davide Martorana
 *
 */
@RestController
@RequestMapping("/api/credit-cards")
public class CreditCardsRestController {

	@Autowired
	private CreditCardPersistenceService cardPersistenceService;
	
	/**
	 * Returns all the credit card of the current logged user.
	 */
	@GetMapping()
	public List<CreditCard> getAll() {
		return this.cardPersistenceService.getAll(SecurityContextHolderUtils.getCurrentUserId()).stream()
				.map( itemCC -> {return CreditCardMapper.mapToRestTO(itemCC);})
				.collect(Collectors.toList());
	}

	/**
	 * Returns the credit card with the given {@code id}, only if it belongs to
	 * the current logged user.
	 * 
	 * @param id
	 *            - id of the wanted credit card.
	 * 
	 */
	@PreAuthorize("hasPermission(#id, 'CREDIT_CARD')")
	@GetMapping("/{id}")
	public CreditCard getOneById(@PathVariable("id") long id) {
		final eu.davidem.wallet.persistence.entities.CreditCard cc = this.cardPersistenceService.getOne(id);
		
		if(cc == null) {
			throw new ResourceNotFoundException("Credit Card Not Found. Id: " + id);
		}
		
		return CreditCardMapper.mapToRestTO(cc);
	}
	
	/**
	 * Returns the credit card with the given {@code id}, only if it belongs to
	 * the current logged user.
	 * 
	 * @param id
	 *            - id of the wanted credit card.
	 * 
	 */
	@GetMapping("/search")
	public List<CreditCard> searchByNumber(@RequestParam("number") final String number) {
		return this.cardPersistenceService.getAllWithNumber(number).stream()
				.map( itemCC -> {return CreditCardMapper.mapToRestTO(itemCC);})
				.collect(Collectors.toList());
	}

	/**
	 * Saves the credit card info in the Body
	 * 
	 * @param cc
	 */
	@PreAuthorize("hasPermission(#creditCard.id, 'CREDIT_CARD')")
	@PostMapping("/save")
	public CreditCard save(@RequestBody final CreditCard creditCard) {
		return CreditCardMapper.mapToRestTO(this.cardPersistenceService.save(creditCard));
	}
}
