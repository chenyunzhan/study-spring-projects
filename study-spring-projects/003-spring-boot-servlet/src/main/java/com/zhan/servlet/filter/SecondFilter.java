package com.zhan.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(getClass());


	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		this.logger.info("SecondFilter Start");
		arg2.doFilter(arg0, arg1);
		this.logger.info("SecondFilter End");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
