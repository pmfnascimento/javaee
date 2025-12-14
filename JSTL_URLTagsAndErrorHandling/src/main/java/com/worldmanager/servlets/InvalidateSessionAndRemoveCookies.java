package com.worldmanager.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class InvalidateSessionAndRemoveCookies
 */
@WebServlet("/invalidatesessionandremovecookies.do")
public class InvalidateSessionAndRemoveCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvalidateSessionAndRemoveCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		s.invalidate();
		
		Cookie[] MyCookies = request.getCookies();
		if (MyCookies != null && MyCookies.length > 0)
		{
			for (Cookie c : MyCookies)
			{
				if (c.getName().toLowerCase().contains("credentials"))
				{
					//expire the cookie
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
		
		response.sendRedirect("ClearSessionsAndCookies.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
