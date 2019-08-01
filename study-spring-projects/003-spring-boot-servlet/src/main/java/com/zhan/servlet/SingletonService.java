package com.zhan.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class SingletonService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	public void printServiceMethod() {
		this.logger.info("==========printServiceMethod==========");
	}

}
