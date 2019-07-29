package com.zhan.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServletConfiguration {
	
	
	
	@Bean
	public ServletRegistrationBean getServletRegistration() {
		ServletRegistrationBean srb = new ServletRegistrationBean(new SecondServlet(), "/second");
		return srb;
	}

}
