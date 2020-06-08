package jp.mirageworld.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
		basePackages = {
				"jp.mirageworld.spring.repositories"
		})
public class JpaConfig {

}
