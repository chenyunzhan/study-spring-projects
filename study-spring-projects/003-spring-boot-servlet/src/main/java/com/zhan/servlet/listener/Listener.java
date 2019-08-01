package com.zhan.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebListener
public class Listener implements ServletContextListener {
	
	private Logger logger = LoggerFactory.getLogger(getClass());


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		this.logger.info("Listener=============={}",arg0.getServletContext().getInitParameter("key"));
	}

}
