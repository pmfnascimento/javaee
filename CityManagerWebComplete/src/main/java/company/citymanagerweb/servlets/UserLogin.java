package company.citymanagerweb.servlets;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userlogin.do")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//here we would put some logic to validate the user.
		//simulate...
		String uid = "authorizeduser";
		int authLevel = 1;
		
		//assuming the user is valid, let's set some information into session
		//in this way, ALL jsp pages and servlets going forward can access the value
		
		//to start a session, get the session from the request into a variable
		//add import javax.servlet.http.HttpSession;
		HttpSession s = request.getSession();
		//just like other examples, use the session variable to get and set attributes
		s.setAttribute("userName", uid);
		s.setAttribute("userAuthLevel", authLevel);
		
		//redirect
		if (authLevel < 1 || uid == null || uid == "")
		{
			//send back to calling page or forward to 
			//unauthorized notification
			// response.sendRedirect("Login.html");
			
			response.sendRedirect(
					response.encodeRedirectURL("Login.html"));
			
		}
		else
		{
			//forward to requested page or menu page/home page with authorization
			//response.sendRedirect("/CityManagerWeb/destinationpage.do");
		
			response.sendRedirect(
					response.encodeRedirectURL("/CityManagerWebComplete/destinationpage.do"));
			
		}
	}

}
