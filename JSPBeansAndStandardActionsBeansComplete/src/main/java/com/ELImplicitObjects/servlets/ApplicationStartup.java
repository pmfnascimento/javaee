package com.ELImplicitObjects.servlets;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationStartup
 *
 */
@WebListener
public class ApplicationStartup implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationStartup() {

    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent ctxt) {
    	//add the application attribute
    	ctxt.getServletContext().setAttribute("uid", "appUser");
    	ctxt.getServletContext().setAttribute("pwd", "appUserPwd");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
