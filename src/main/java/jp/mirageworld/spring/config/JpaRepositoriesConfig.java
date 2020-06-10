package jp.mirageworld.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "jp.mirageworld.spring.repositories")
@DependsOn("flyway")
public class JpaRepositoriesConfig {

}
