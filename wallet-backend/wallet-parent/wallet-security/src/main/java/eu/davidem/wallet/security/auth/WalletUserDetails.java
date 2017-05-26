package eu.davidem.wallet.security.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Wallet version of UseeDetails
 * 
 * @author Davide Martorana
 *
 */
public class WalletUserDetails extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3751263893746909312L;
	
	private final long id;

	public WalletUserDetails(final long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.id = id;
	}

	public long getId() {
		return this.id;
	}
	
}
