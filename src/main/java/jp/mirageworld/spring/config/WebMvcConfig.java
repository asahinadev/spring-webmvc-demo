package jp.mirageworld.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan("jp.mirageworld.spring")
public class WebMvcConfig
		extends WebMvcConfigurationSupport {

	@Override
	protected void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp().prefix("/WEB-INF/pages/").suffix(".jsp");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
