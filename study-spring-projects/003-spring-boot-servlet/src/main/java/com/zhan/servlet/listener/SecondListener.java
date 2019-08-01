package com.zhan.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SecondListener implements ServletContextListener {
	
	private Logger logger = LoggerFactory.getLogger(getClass());


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		this.logger.info("SecondListener=============={}",arg0.getServletContext().getInitParameter("key"));
	}

}
