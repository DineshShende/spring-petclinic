package org.springframework.samples.petclinic.configuration;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dandelion.core.web.DandelionFilter;
import com.github.dandelion.core.web.DandelionServlet;
import com.github.dandelion.datatables.core.web.filter.DatatablesFilter;

@Configuration
public class DandelionConfiguration {

	@Bean
	public ServletRegistrationBean dandelionServlet() {
		ServletRegistrationBean srb = new ServletRegistrationBean(new DandelionServlet(), DandelionServlet.DANDELION_ASSETS_URL_PATTERN);
		srb.setLoadOnStartup(2);
		return srb;
	}
	
	@Bean
	public FilterRegistrationBean dandelionFilter() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new DandelionFilter());
		return frb;
	}
	
	@Bean
	public FilterRegistrationBean datatablesFilter() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new DatatablesFilter());
		return frb;
	}
}
