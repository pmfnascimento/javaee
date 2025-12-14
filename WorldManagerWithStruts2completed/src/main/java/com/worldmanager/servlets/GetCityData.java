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
 * Servlet implementation class GetCityData
 */
@WebServlet("/getcitydata.do")
public class GetCityData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCityData() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		String baseURL = getServletContext().getInitParameter("baseURL");
		
		//get the cities
		if (getServletContext().getAttribute("WorldDBManager") != null)
		{
			//interact with manager models
			DBManager dbm = (DBManager)getServletContext().getAttribute("WorldDBManager");
			CityManager cm = new CityManager();
			
			//build a list of city objects using the query
			ArrayList<City> allCities = cm.getUSCitiesByDistrictByPopulation(dbm);
			//add the cities to the session
			s.setAttribute("cityData", allCities);
			//direct to the view
			response.sendRedirect(baseURL + "/Protected/listCities.jsp");
		}
		else
		{
			s.setAttribute("cityData", null);
			response.sendRedirect(baseURL + "/login.jsp");
		}
	}
}
