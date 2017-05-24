package eu.davidem.wallet.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import eu.davidem.wallet.persistence.config.PersistenceConfig;

/**
 * Main Application Configuration
 * 
 * All the configurations need to be kicked-in in the project have to be
 * imported here.
 * 
 * @author Davide Martorana
 *
 */
@Import({PersistenceConfig.class})
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
}
