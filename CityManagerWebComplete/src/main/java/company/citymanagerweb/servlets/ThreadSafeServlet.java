package company.citymanagerweb.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThreadSafeServlet
 */
@WebServlet("/threadsafeservlet.do")
public class ThreadSafeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreadSafeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//synchronize the servlet context to avoid multiple resources writing concurrently
		synchronized(getServletContext()) {
			//get the attribute and multiply by two to increase 
			//factor but pretend this is a longer running process...
			StringBuilder msg = new StringBuilder("");
			msg.append("<html><body>");
			int currentSeed = (int)getServletContext().getAttribute("currentSeedValue");
			msg.append(String.format("Attribute Retrieved Value: %d<br>", currentSeed));
			currentSeed *= 2;
			//set the value
			getServletContext().setAttribute("currentSeedValue", currentSeed);
			try {
				Thread.sleep(5000);  //wait 5 seconds...
			} catch (InterruptedException e) {
				//do nothing...
			}
			//re-fetch the value after waiting...
			currentSeed = (int)getServletContext().getAttribute("currentSeedValue");
			msg.append(String.format("Attribute retrieved value after process: %d<br>"
									, currentSeed));
			msg.append("</body></html>");
			
			//spit it out
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(msg);
		}
	}
}
