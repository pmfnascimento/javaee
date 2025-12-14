package com.worldmanager.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.worldmanager.dbhelpers.*;
import com.worldmanager.dbmodels.*;
import com.worldmanager.models.Country;


/**
 * Servlet implementation class GetAllCountries
 */
@WebServlet("/getallcountries.do")
public class GetAllCountries extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllCountries() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//make sure user is logged in
		String target = "";
		HttpSession s = request.getSession();
		if (s.getAttribute("authorized_user") != null)
		{
			//get the countries and direct on
			if (getServletContext().getAttribute("WorldDBManager") != null)
			{
				DBManager dbm = (DBManager)getServletContext().getAttribute("WorldDBManager");
				if (!dbm.isConnected())
				{
					if (!dbm.openConnection()) 
					{
						//log it
						throw new IOException("Could not connect to database and open connection");
					}
				}
				
				//build a list of country objects using the query
				ArrayList<Country> allCountries = new ArrayList<Country>();
				String query = DBWorldQueries.getCountriesByName();
				try
				{
					ResultSet rs = dbm.ExecuteResultSet(query);
					while (rs.next())
					{
						Country c = new Country();
						c.setCapital(rs.getString("Capital"));
						c.setCode(rs.getString("Code"));
						c.setCode2(rs.getString("Code2"));
						c.setContinent(rs.getString("Continent"));
						c.setGnp(rs.getDouble("GNP"));
						c.setGnpOld(rs.getDouble("GNPOld"));
						c.setGovernmentForm(rs.getString("GovernmentForm"));
						c.setHeadOfState(rs.getString("HeadOfState"));
						c.setIndepYear(rs.getInt("IndepYear"));
						c.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
						c.setLocalName(rs.getString("LocalName"));
						c.setName(rs.getString("Name"));
						c.setPopulation(rs.getInt("Population"));
						c.setRegion(rs.getString("Region"));
						c.setSurfaceArea(rs.getDouble("SurfaceArea"));
						allCountries.add(c);
					}
					s.setAttribute("AllCountries", allCountries);
					//forward
					target = "ShowAllCountries.jsp";
				}
				catch (Exception ex)
				{
					//log it
					throw new IOException("Query could not be executed for get all countries by name");
				}
			}
		}
		else
		{
			target = "login.jsp?dest=listCountries";
		}
		response.sendRedirect(target);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
