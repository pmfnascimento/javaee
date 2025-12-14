package company.citymanagerweb.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Authorized
 */
@WebServlet("/authorized.do")
public class Authorized extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authorized() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		boolean authorized = false;
		String uid = null;
		int authLevel = -1;
		if (s.getAttribute("userName") != null)
		{
			uid = (String)s.getAttribute("userName");
		}
		if (s.getAttribute("userAuthLevel") != null)
		{
			authLevel = (int)s.getAttribute("userAuthLevel");
		}
		
		if (authLevel >= 1 && uid != null && !uid.equals(""))
		{
			authorized = true;
		}
		
		if (!authorized)
		{
			response.sendRedirect("Login.html");
		}
		else
		{
			response.sendRedirect("/CityManagerWebComplete/destinationpage.do");
		}
	}
}
