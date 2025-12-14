package company.citymanagerweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DestinationPage
 */
@WebServlet("/destinationpage.do")
public class DestinationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestinationPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession s = request.getSession();
		if (s != null && !s.isNew() && s.getAttribute("userName") != null)
		{
			String uid = (String)s.getAttribute("userName");
			out.println("<html><body><span>Welcome<span>&nbsp;<strong>"
					+ uid + "</strong></body></html>");
		}
		else
		{
			out.println("<html><body><span>Unauthorized<span>"
					+ "</body></html>");
		}
	}

	

}
