package com.worldmanager.taghandlers;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.*;
import com.worldmanager.models.*;

import java.io.IOException;
import java.util.*;

public class Navigator extends SimpleTagSupport{
	private ArrayList<NavigationDetails> links;
	
	private void CreateNavigationLinks(){
		links = new ArrayList<NavigationDetails>();
		
		NavigationDetails nd = new NavigationDetails();
		nd.setLink("index.jsp");
		nd.setText("Home");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink("login.jsp");
		nd.setText("Login");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink("listCities.jsp");
		nd.setText("View Cities");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink("listCountries.jsp");
		nd.setText("View Countries");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink("signout.do");
		nd.setText("Sign Out");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink("invalidatesessionandremovecookies.do");
		nd.setText("Clear All User Data");
		links.add(nd);
	}
	
	public void doTag() throws JspException, IOException{
		//create the links
		CreateNavigationLinks();
		//iterate the links to the page
		for (NavigationDetails nd : links)
		{
			getJspContext().setAttribute("navdetails", nd);
			getJspBody().invoke(null);
		}
	}
}
