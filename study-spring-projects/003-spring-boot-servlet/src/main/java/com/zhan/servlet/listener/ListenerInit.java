package com.zhan.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerInit implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		arg0.setInitParameter("key", "value");
	}

}
