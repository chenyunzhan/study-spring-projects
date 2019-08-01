package com.zhan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		logger.info("info================="+response.getContentType());
		logger.debug("debug================"+response.getContentType());
		logger.warn("warn======================"+response.getContentType());
		logger.error("error==============="+response.getContentType());
		logger.trace("trace====================="+response.getContentType());
		response.getWriter().println("<h1>你爱不爱我？？？？？？？？？？？？？？</h1>");

	}
	
}
