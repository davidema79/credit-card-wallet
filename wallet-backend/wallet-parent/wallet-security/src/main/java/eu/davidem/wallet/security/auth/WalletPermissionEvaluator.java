package eu.davidem.wallet.security.auth;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import eu.davidem.wallet.persistence.entities.CreditCard;
import eu.davidem.wallet.persistence.repos.CreditCardsRepository;

/**
 * Permission Evaluator for the Wallet
 * 
 * @author Davide Martorana
 *
 */
public class WalletPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private CreditCardsRepository repository;
	
	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject,
			Object permission) {
		final String permissionString = (String) permission;
		
		if (!permissionString.equals("CREDIT_CARD") ) {
			// Not an expected type of permission request
			return false;
		}
		
		final WalletUserDetails userDetails = (WalletUserDetails) authentication.getPrincipal();
		
		final Long idCreditCard = (Long) targetDomainObject;
		
		final List<CreditCard> list = this.repository.findAllByIdAndUserId(idCreditCard, userDetails.getId());
		
		return !list.isEmpty();
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId,
			String targetType, Object permission) {
		return this.hasPermission(authentication, targetId, permission);
	}

}
