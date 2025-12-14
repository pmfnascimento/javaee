package com.worldmanager.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.worldmanager.models.*;

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
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		//simulate login
		int authLevel = 1;
		
		//create webUser
		WebUser wu = new WebUser();
		wu.setUserId(uid);
		wu.setPassword(pwd);
		wu.setAuthLevel(authLevel);
		
		//set wu into session as authorized_user
		HttpSession s = request.getSession();
		s.setAttribute("authorized_user", wu);
		
		//add cookie if user wants to
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
		
		//direct to destination
		String target = ((request.getParameter("dest") == null
							|| request.getParameter("dest") == "")
							? "index.jsp"
							: request.getParameter("dest") + ".jsp");
		response.sendRedirect(target);
	}
}
