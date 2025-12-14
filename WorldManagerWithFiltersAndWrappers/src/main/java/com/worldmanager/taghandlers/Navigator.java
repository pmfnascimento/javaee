package com.worldmanager.taghandlers;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;
import com.worldmanager.models.*;

import java.io.IOException;
import java.util.*;

public class Navigator extends SimpleTagSupport{
	private ArrayList<NavigationDetails> links;
	
	private void CreateNavigationLinks(){
		links = new ArrayList<NavigationDetails>();
		String root = "http://localhost:8080/";
		String app = "WorldManagerWithFiltersAndWrappers/";
		
		NavigationDetails nd = new NavigationDetails();
		nd.setLink(String.format("%s%sindex.jsp"
					, root, app));
		nd.setText("Home");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink(String.format("%s%slogin.jsp"
					, root, app));
		nd.setText("Login");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink(String.format("%s%sProtected/listCities.jsp"
				, root, app));
		nd.setText("View Cities");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink(String.format("%s%sProtected/listCountries.jsp"
				, root, app));
		nd.setText("View Countries");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink(String.format("%s%sProtected2/listCities.jsp"
				, root, app));
		nd.setText("View Cities 2");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink(String.format("%s%sProtected2/listCountries.jsp"
				, root, app));
		nd.setText("View Countries 2");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink(String.format("%s%ssignout.do"
					, root, app));
		nd.setText("Sign Out");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink(String.format("%s%sinvalidatesessionandremovecookies.do"
					, root, app));
		nd.setText("Clear All User Data");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink(String.format("%s%sparameterInterceptor.jsp?interceptedparam=all_small_at_start"
					, root, app));
		nd.setText("Parameter Interceptor");
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
