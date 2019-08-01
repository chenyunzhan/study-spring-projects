package com.zhan.servlet.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondFilterConfiguration {

	@Bean FilterRegistrationBean getBean() {
		FilterRegistrationBean frb = new FilterRegistrationBean(new SecondFilter());
		return frb;
	}
	
	
}
