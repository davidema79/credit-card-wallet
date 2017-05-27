package eu.davidem.wallet.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import eu.davidem.wallet.security.auth.WalletPermissionEvaluator;
import eu.davidem.wallet.security.auth.handlers.NoneRedirectStrategy;
import eu.davidem.wallet.security.auth.handlers.WalletSuccessHandler;
import eu.davidem.wallet.security.auth.services.UserDetailsPersistenceService;
import eu.davidem.wallet.security.auth.services.WalletAuthenticationProvider;
import eu.davidem.wallet.security.auth.services.WalletUserDetailsService;

/**
 * Security Configurations
 * 
 * @author Davide Martorana
 *
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PermissionEvaluator walletPermissionEvaluator() {
		return new WalletPermissionEvaluator();
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		//@formatter:off
		http
			.csrf().disable()
			.cors()
			.and()
				.authorizeRequests()
					.antMatchers("/static/**", "/index.html", "/health-check/**").permitAll()
					.antMatchers("**.js", "/*").permitAll()
					.antMatchers("/signup").permitAll()
				.anyRequest().authenticated()
			// .and().rememberMe()
			.and()
				.formLogin()
					.loginPage("/login")
						.successHandler(authenticationSuccessHandler())
					.failureUrl("/login").permitAll()
					.and()
						.exceptionHandling()
						.authenticationEntryPoint(new org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint("Invalid username or password."))
			.and()
				.logout().permitAll();
		//@formatter:on
	}

	@Override
	public void configure(final AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		auth.inMemoryAuthentication().withUser("root").password("1qaz!QAZ").roles("USER", "ADMIN", "ROOT");

		auth.authenticationProvider(authenticationProvider());
		// @formatter:on
	}

	@Override
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		final WalletSuccessHandler handler = new WalletSuccessHandler();
		handler.setRedirectStrategy(new NoneRedirectStrategy());

		return handler;
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		return new WalletAuthenticationProvider(userDetailsService(), bCryptPasswordEncoder());
	}

	@Bean
	public WalletUserDetailsService userDetailsService() {
		return new WalletUserDetailsService();
	}
	
	@Bean
	public UserDetailsPersistenceService userDetailsPersistenceService() {
		return new UserDetailsPersistenceService();
	}
	
	
}
