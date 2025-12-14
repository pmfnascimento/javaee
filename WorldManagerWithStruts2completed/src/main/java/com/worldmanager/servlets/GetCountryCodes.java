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
import com.worldmanager.modelmanagers.CountryManager;
import com.worldmanager.models.WebUser;

/**
 * Servlet implementation class GetCountryCodes
 */
@WebServlet("/getcountrycodes.do")
public class GetCountryCodes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCountryCodes() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String baseURL = getServletContext().getInitParameter("baseURL");
		HttpSession s = request.getSession();
		
		//make sure user is part of the admin schema or get out:
		if (s.getAttribute("authorized_user") == null)
		{
			response.sendRedirect(baseURL + "/login.jsp");
			return;
		}
		else
		{
			WebUser wu = (WebUser)s.getAttribute("authorized_user");
			if (wu.getAuthLevel() < 2)
			{
				response.sendRedirect(baseURL + "/login.jsp");
				return;
			}
		}
		
		//get the country codes
		if (getServletContext().getAttribute("WorldDBManager") != null)
		{
			DBManager dbm = (DBManager)getServletContext().getAttribute("WorldDBManager");
			CountryManager cm = new CountryManager();
			//add the country codes to session
			ArrayList<String> cCodes = cm.getCountryCodes(dbm);
			s.setAttribute("countryCodes", cCodes);
			//send the user on..
			if (cCodes != null && cCodes.size() > 0)
			{
				response.sendRedirect(baseURL + "/Protected/addCity.jsp");
			}
			else
			{
				response.sendRedirect(baseURL + "../errorHandler.jsp");
			}
		}
		else
		{
			response.sendRedirect(baseURL + "../errorHandler.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
