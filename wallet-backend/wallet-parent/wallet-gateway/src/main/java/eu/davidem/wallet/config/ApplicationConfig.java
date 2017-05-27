package eu.davidem.wallet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import eu.davidem.wallet.persistence.config.PersistenceConfig;
import eu.davidem.wallet.security.config.SecurityConfig;
import eu.davidem.wallet.services.CreditCardPersistenceService;
import eu.davidem.wallet.services.UserPersistenceService;


/**
 * Main Application Configuration
 * 
 * All the configurations need to be kicked-in in the project have to be
 * imported here.
 * 
 * @author Davide Martorana
 *
 */
@Import({PersistenceConfig.class, SecurityConfig.class})
public class ApplicationConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
	
	@Bean
	public CreditCardPersistenceService cardPersistenceService() {
		return new CreditCardPersistenceService();
	}
	
	
	@Bean
	public UserPersistenceService userPersistenceService() {
		return new UserPersistenceService();
	}
}
