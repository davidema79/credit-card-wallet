package eu.davidem.wallet.security.config;

import org.springframework.security.core.context.SecurityContextHolder;

import eu.davidem.wallet.security.auth.WalletUserDetails;

/**
 * Utility to avoid boilerplate code
 * 
 * @author Davide Martorana
 *
 */
public final class SecurityContextHolderUtils {

	
	private SecurityContextHolderUtils() {
		throw new IllegalAccessError("THis class cannot be instanciated at runtime.");
	}
	
	
	public static WalletUserDetails getWalletUserDetails() {
		return (WalletUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public static  long getCurrentUserId() {
		return SecurityContextHolderUtils.getWalletUserDetails().getId();
	}
}
