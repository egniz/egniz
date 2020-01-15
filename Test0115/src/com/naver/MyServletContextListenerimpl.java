package com.naver;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


//@WebListener
public class MyServletContextListenerimpl implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("sc종료");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("sc시작");
		
	}

}
