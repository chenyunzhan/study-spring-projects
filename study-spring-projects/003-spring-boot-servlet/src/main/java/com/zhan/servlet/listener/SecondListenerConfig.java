package com.zhan.servlet.listener;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhan.servlet.filter.SecondFilter;


/**
 * 存在一个问题，当配置listner时，secondFilter会被覆盖
 * @author ZHAN
 *
 */
@Configuration
public class SecondListenerConfig {
	
	@Bean ServletListenerRegistrationBean<SecondListener> getBean(){
		ServletListenerRegistrationBean<SecondListener> srb = new ServletListenerRegistrationBean<>(new SecondListener());
		return srb;
	}
	
	
//	@Bean FilterRegistrationBean getFilterBean() {
//		FilterRegistrationBean frb = new FilterRegistrationBean(new SecondFilter());
//		return frb;
//	}
}
