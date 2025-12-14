package com.worldmanager.taghandlers;
import com.worldmanager.models.*;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.*;
import java.io.IOException;
import java.util.*;

public class CityIterator extends SimpleTagSupport{
	private ArrayList<City> cities;
	
	/**
	 * Mutator for City List.
	 * @param value the list of Cities to iterate
	 */
	public void setCityList(ArrayList<City> value)
	{
		cities = value;
	}
	
	public void doTag() throws JspException, IOException{
		for (City c : cities)
		{
			getJspContext().setAttribute("city", c);
			getJspBody().invoke(null);
		}
	}
}
