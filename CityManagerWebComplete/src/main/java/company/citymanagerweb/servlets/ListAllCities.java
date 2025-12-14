package company.citymanagerweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import company.citymanagerweb.models.DBManager;
import company.citymanagerweb.models.MySQLServerConnectionBehavior;
import company.citymanagerweb.models.ServerConnectionBehavior;

/**
 * Servlet implementation class ListAllCities
 */
@WebServlet("/listallcities.do")
public class ListAllCities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllCities() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//generate the output in a StringBuilder
		StringBuilder sb = new StringBuilder("<html><body>");
		
		//get db con info from context init params
		String uid = getServletContext().getInitParameter("dbuserid");
		String pwd = getServletContext().getInitParameter("dbuserpwd");
		String cat = getServletContext().getInitParameter("dbinitcat");

		//set the scb for mySQL
		ServerConnectionBehavior scb = new MySQLServerConnectionBehavior(uid, pwd, cat);
		System.out.println(scb.getConnectionDetails());
		System.out.println(scb.getConnectionURL());
		
		//create the manager
		DBManager dbm = new DBManager(scb);
		
		try
		{
			//connect to the db and open the connection
			if (!dbm.isConnected())
			{
				if (!dbm.openConnection()) 
				{
					//massive failure, log it
					sb.append("Could not connect to the database...");
				}
			}
			
			//ID NAME CountryCode District Population
			//get the cities into a table:
			sb.append("<table border=1>" 
						+ "<tr><td>ID</td><td>NAME</td><td>COUNTRY_CODE</td>"
						+ "<td>DISTRICT</td><td>POPULATION</td></tr>");
			
			//is this MVC? NO.  Queries should be logic outside of the controller.
			//views should handle the results.  We clearly have a way to go to
			//get ot MVC from here.
			String query = "select * from city where CountryCode = 'PT'" +
							" order by District ASC, Population DESC";
			ResultSet rs = dbm.ExecuteResultSet(query);
			while (rs.next())
			{
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String ctry = rs.getString("CountryCode"); 
				String dist = rs.getString("District"); 
				int pop = rs.getInt("Population");
				
				sb.append("<tr><td>" + id + "</td>" 
						+ "<td>" + name + "</td>" 
						+ "<td>" + ctry + "</td>" +
						"<td>" + dist + "</td>" +
						"<td>" + pop + "</td></tr>");
			}
			sb.append("</table>");
		}
		catch(Exception e)
		{
			sb.append("<h1>ERROR: " + e.getMessage() + "</h1>");
		}
		sb.append("</body></html>");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(sb);
	}

}
