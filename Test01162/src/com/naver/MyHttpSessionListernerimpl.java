package com.naver;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionListernerimpl
 *
 */
public class MyHttpSessionListernerimpl implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyHttpSessionListernerimpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
      System.out.println("..");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
        System.out.println("....");
    }
	
}
