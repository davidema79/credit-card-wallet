package eu.davidem.wallet.security.auth.services;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class WalletAuthenticationProvider extends DaoAuthenticationProvider {

	public WalletAuthenticationProvider(final UserDetailsService service, final BCryptPasswordEncoder encoder) {
		this.setUserDetailsService(service);
		this.setPasswordEncoder(encoder);
	}
	
}
