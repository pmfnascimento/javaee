package com.worldmanager.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/loginuser.do")
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
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		//simulate login
		HttpSession s = request.getSession();
		s.setAttribute("uid", uid);
		s.setAttribute("pwd", pwd);
		int authLevel = 1;
		s.setAttribute("authlevel", authLevel);
		
		//redirect
		String destination = "listCities.jsp";
		if (request.getAttribute("dest") != null)
		{
			destination = (String)request.getAttribute("dest");
		}
		if (destination != null && destination.equals("listcities"))
		{
			destination = "listCities.jsp";
		}
		
		if (request.getParameter("rememberMe") != null)
		{
			String rememberMe = request.getParameter("rememberMe");
			if (rememberMe.equalsIgnoreCase("ON"))
			{
				//we also want to store the information in a cookie
				//for reuse later:
				int cookieLife = 3600*24*7; //7 days
				Cookie uidCook = new Cookie("credentials_uid",uid);
				uidCook.setMaxAge(cookieLife);  //7 days
				response.addCookie(uidCook);
				Cookie pwdCook = new Cookie("credentials_pwd",pwd);
				uidCook.setMaxAge(cookieLife);  //7 days
				response.addCookie(pwdCook);
			}
		}
		
		//redirect
		if (authLevel < 1 || uid == null || uid == "")
		{
			//send back to calling page or forward to 
			//unauthorized notification
			response.sendRedirect(
					response.encodeRedirectURL("login.jsp"));
			
		}
		else
		{
			//if use request dispatcher place a / in front of url
			//RequestDispatcher rd = request.getRequestDispatcher("/" + destination);
			//rd.forward(request, response);
			response.sendRedirect(response.encodeRedirectURL(destination));
		}
	}
}
