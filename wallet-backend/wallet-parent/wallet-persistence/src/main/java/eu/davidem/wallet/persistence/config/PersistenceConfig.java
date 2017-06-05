package eu.davidem.wallet.persistence.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import eu.davidem.wallet.persistence.entities.CreditCard;
import eu.davidem.wallet.persistence.repos.UsersRepository;

/**
 * Persistence Configuration to be imported from the Main Configuration
 * 
 * Any kind of configurations tight to the persistence layer belong to here.
 * 
 * @author Davide Martorana
 *
 */
@EnableJpaRepositories(basePackageClasses = { UsersRepository.class })
public class PersistenceConfig {

	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final EntityManagerFactoryBuilder builder, final DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages(CreditCard.class)
				.build();
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
