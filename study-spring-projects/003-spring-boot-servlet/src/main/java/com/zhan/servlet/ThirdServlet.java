package com.zhan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;


@WebServlet(urlPatterns = {"/third"})
public class ThirdServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired SingletonService singletonService;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.singletonService.printServiceMethod();
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<h1>我</h1>");
		response.getWriter().println(this.singletonService);
	}
	
	

}
