package eu.davidem.wallet.security.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security Configurations
 * 
 * @author Davide Martorana
 *
 */
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	
	
	
}
