package jp.mirageworld.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource dataSource() {
		try {
			return new JndiDataSourceLookup().getDataSource("jdbc/spring-webmvc-demo");
		} catch (DataSourceLookupFailureException e) {
			log.warn(e.getMessage(), e);
			return new DriverManagerDataSource("jdbc:h2::mem:test", "sa", "");
		}
	}

}
