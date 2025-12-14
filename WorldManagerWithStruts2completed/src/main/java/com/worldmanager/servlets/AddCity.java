package com.worldmanager.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.worldmanager.dbmodels.DBManager;
import com.worldmanager.modelmanagers.CityManager;
import com.worldmanager.models.City;

/**
 * Servlet implementation class AddCity
 */
@WebServlet("/Protected/addnewcity.do")
public class AddCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCity() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//add a city
		String name = request.getParameter("cityName");
		String countryCode = request.getParameter("cityCountryCode");
		String district = request.getParameter("cityDistrict");
		String population = request.getParameter("cityPopulation");
		String baseURL = getServletContext().getInitParameter("baseURL");
		
		try
		{
			/**
			 * Add a new city
			 */
			//use the Models to insert and retrieve the city data
			if (getServletContext().getAttribute("WorldDBManager") != null)
			{
				DBManager dbm = (DBManager)getServletContext().getAttribute("WorldDBManager");
				CityManager cm = new CityManager();
				
				//we could do either here:
				/*
				City c = new City();
				c.setCountryCode(countryCode);
				c.setDistrict(district);
				c.setPopulation(Integer.parseInt(population));
				c.setName(name);
				c.setId(-1);
				c = cm.insertCity(dbm, c);
				*/
				//or
				City c = cm.insertCity(dbm, name, countryCode, district, Integer.parseInt(population));
				if (c == null)
				{
					//didn't work, try again:
					response.sendRedirect(baseURL + "/Protected/addCity.jsp");
				}
				//now because we have modeled correctly, we can easily refresh data here, 
				//rather than redirecting around to do so!
				ArrayList<City> allCities = cm.getUSCitiesByDistrictByPopulation(dbm);
				//make the city data fresh
				HttpSession s = request.getSession();
				s.setAttribute("cityData", allCities);
				
				//take the view back to the city list
				response.sendRedirect(baseURL + "/Protected/listCities.jsp");
			}
			else
			{
				//log it... and throw new Exception ("No database connection.");
				response.sendRedirect(baseURL + "/errorHandler.jsp");
			}
		}
		catch (Exception ex)
		{
			//log it.
			response.sendRedirect(baseURL + "/errorHandler.jsp");
		}
	}

}
