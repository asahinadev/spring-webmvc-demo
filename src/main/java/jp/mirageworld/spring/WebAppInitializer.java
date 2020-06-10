package jp.mirageworld.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jp.mirageworld.spring.config.ApplicationConfig;
import jp.mirageworld.spring.config.WebMvcConfig;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "jp.mirageworld.spring")
@Order(2)
public class WebAppInitializer
		extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected String[] getServletMappings() {
		return $("/");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return $(ApplicationConfig.class);
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return $(WebMvcConfig.class);
	}

	<T> T[] $(@SuppressWarnings("unchecked") T... objects) {
		return objects;
	}

	Class<?>[] $(Class<?>... objects) {
		return objects;
	}

}