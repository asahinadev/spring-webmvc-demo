package jp.mirageworld.spring.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@DependsOn({
		"flyway"
})
public class DataConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		log.debug("{}", "jpaVendorAdapter");
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setDatabase(Database.H2);
		jpaVendorAdapter.setGenerateDdl(false);

		return jpaVendorAdapter;
	}

	@Bean("entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		log.debug("{}", "entityManagerFactory");
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();

		bean.setPackagesToScan("jp.mirageworld.spring");
		bean.setDataSource(dataSource);
		bean.setJpaVendorAdapter(jpaVendorAdapter());
		bean.setJpaPropertyMap(Map.of(
				"hibernate.hbm2ddl.auto", "validate",
				"hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy",
				"hibernate.connection.charSet", "UTF-8",
				"hibernate.show_sql", true,
				"hibernate.format_sql", true,
				"hibernate.use_sql_comments", false,
				"hibernate.jdbc.batch_size", 30,
				"hibernate.jdbc.fetch_size", 30
		// end of property
		));

		return bean;
	}

	@Bean
	public TransactionManager transactionManager() {
		log.debug("{}", "transactionManager");
		JpaTransactionManager tx = new JpaTransactionManager();
		return tx;
	}

}
