package eu.davidem.wallet.gateway.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for Credit Cards operations
 * 
 * @author Davide Martorana
 *
 */
@RestController
@RequestMapping("/api/credit-cards")
public class CreditCardsRestController {

	/**
	 * Returns all the credit card of the current logged user.
	 */
	@GetMapping()
	public String getAll() {
		return "getAll";
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
		return "save " + cc ;
	}
}
