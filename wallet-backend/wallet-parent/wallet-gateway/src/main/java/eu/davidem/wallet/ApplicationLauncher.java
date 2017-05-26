package eu.davidem.wallet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import eu.davidem.wallet.config.ApplicationConfig;

/**
 * Application Starter. 
 * 
 * 
 * @author Davide Martorana
 *
 */
@SpringBootApplication
@Import({ApplicationConfig.class})
public class ApplicationLauncher {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationLauncher.class);

	public static void main(String[] args) {

		LOGGER.info("############################################################################################");
		LOGGER.info("###########            APPLICATION eWALLET FOR CREDIT CARD STARTING....          ###########");
		LOGGER.info("############################################################################################");
		try {
			SpringApplication.run(ApplicationLauncher.class, args);
		} catch (final Exception e) {
			LOGGER.info("############################################################################################################");
			LOGGER.info("###########        ....APPLICATION eWALLET FOR CREDIT CARD FAILED TO START       ###########################");
			LOGGER.info("############################################################################################################");
			LOGGER.error("Exception: {}", e.getMessage(), e);
			
			System.exit(-1);
		}

		LOGGER.info("############################################################################################");
		LOGGER.info("###########            .....APPLICATION eWALLET FOR CREDIT CARD STARTED          ###########");
		LOGGER.info("############################################################################################");
	}
	
	
	
}
