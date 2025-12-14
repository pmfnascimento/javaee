package com.worldmanager.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.worldmanager.dbmodels.DBManager;
import com.worldmanager.modelmanagers.CookieManager;
import com.worldmanager.modelmanagers.WebUserManager;
import com.worldmanager.models.WebUser;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/loginUser.do")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		WebUser wu = (WebUser)s.getAttribute("authorized_user");
		WebUserManager wum = new WebUserManager();
		
		String baseURL = request.getServletContext().getInitParameter("baseURL");
		String loginError = baseURL + "/loginError.jsp";
		String uid = "";
		String pwd = "";
		
		if (!wum.userIsValid(wu))
		{
			//get parameters and validate not empty:
			if (request.getParameter("uid") != null)
			{
				uid = request.getParameter("uid");
			}
			if (request.getParameter("pwd") != null)
			{
				pwd = request.getParameter("pwd");
			}
			if (!wum.validateParams(uid, pwd))
			{
				//bad data
				response.sendRedirect(loginError);
			}
			
			//use models to get matching user
			if (getServletContext().getAttribute("WorldDBManager") != null)
			{
				DBManager dbm = (DBManager)getServletContext().getAttribute("WorldDBManager");
				wu = wum.getWebUserByCredentials(dbm, uid, pwd);
				if (wu == null)
				{
					response.sendRedirect(loginError);
					return;
				}
				s.setAttribute("authorized_user", wu);
				
				//add cookie if user wants to
				if (request.getParameter("rememberMe") != null)
				{
					String rememberMe = request.getParameter("rememberMe");
					if (rememberMe.equalsIgnoreCase("ON"))
					{
						CookieManager cmgr = new CookieManager();
						cmgr.AddCredentials(response, wu);
					}
				}
			}
		}
		
		//direct to destination
		String destination = ((request.getParameter("dest") == null
							|| request.getParameter("dest") == "")
							? baseURL + "/index.jsp"
							: baseURL + "/" + request.getParameter("dest") + ".jsp");
		response.sendRedirect(destination);
	}
}
