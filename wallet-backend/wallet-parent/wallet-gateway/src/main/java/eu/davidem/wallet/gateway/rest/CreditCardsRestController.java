package eu.davidem.wallet.gateway.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.davidem.wallet.gateway.rest.to.CreditCard;
import eu.davidem.wallet.gateway.rest.to.CreditCardMapper;
import eu.davidem.wallet.persistence.CreditCardPersistenceService;

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
		return this.cardPersistenceService.getAll(1).stream()
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
	@GetMapping("/{id}")
	public String getOneById(@PathVariable("id") long id) {
		return "getOneById: " + id;
	}

	/**
	 * Saves the credit card info in the Body
	 * 
	 * @param cc
	 */
	@PostMapping("/save")
	public String save(@RequestBody long cc) {
//		CreditCardValidator.VISA;
		return "save " + cc ;
	}
}
