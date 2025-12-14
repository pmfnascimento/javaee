package com.worldmanager.wrappers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Create a parameter inspector to intercept and
 * capitalize a parameter if found
 * Needs to be implemented via a filter..
 *
 */
public class ParameterInspector extends HttpServletRequestWrapper{

	public ParameterInspector(HttpServletRequest request) {
		super(request);
		//System.out.println("Constructed");
	}

	//intercept requests to get parameters from the request
	public String[] getParameterValues(String p)
	{
		//get originals
		String[] values = super.getParameterValues(p);
		if (values == null) return null;
		ArrayList<String> newValues = new ArrayList<String>();
		
		//change all the text to Caps for parameter 
		//interceptedParam
		for (String s : values)
		{
			if (p.equalsIgnoreCase("interceptedparam"))
			{
				s = s.toUpperCase();
			}
			newValues.add(s);
		}
		return (String[])newValues.toArray();
	}
	
	//single param
	public String getParameter(String p)
	{
		String value = super.getParameter(p);
		if (value == null) return null;
		if (p.equalsIgnoreCase("interceptedparam"))
		{
			return value.toUpperCase();
		}
		return value;
	}
	
	//hijack a header if you want..
	public String getHeader(String h)
	{
		return super.getHeader(h);
	}
}
