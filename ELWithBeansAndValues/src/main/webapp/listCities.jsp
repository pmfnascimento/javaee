<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.worldmanager.dbmodels.*
    		, com.worldmanager.dbhelpers.*
    		, com.worldmanager.models.*
    		, java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<%!
		String uid = "";
		String pwd = "";
		DBManager dbm;
		WebUser wu;
	%>
	<%
		//make sure user is logged in
		if (session.getAttribute("authorized_user") == null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp?dest=listCities");
			rd.forward(request, response);
		}
		else
		{
			wu = (WebUser)session.getAttribute("authorized_user");
			Integer authLevel = (Integer)wu.getAuthLevel();
			if (authLevel < 1)
			{
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp?dest=listCities");
				rd.forward(request, response);
			}
			
			if (wu.getUserId() != null && !wu.getUserId().equals(""))
			{
				uid = wu.getUserId();
			}
			if (wu.getPassword() != null && !wu.getPassword().equals(""))
			{
				pwd = wu.getPassword();
			}
		}
		
	%>
	<%
		if (uid != null && !uid.equals(""))
		{
			%>
				<h1>Welcome Back <%= uid %></h1>
			<% 
		}
	%>
	
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<%@ include file="navbar.jsp" %>
			</td>
			<td style="width:75%;height:80%;">
				<%-- We don't know how to use
					 expressions yet so we'll do it all here --%>
				<%
					//get the DBManager from context
					dbm = (DBManager)application.getAttribute("WorldDBManager");
					
					//generate the output in a StringBuilder
					
					//java.lang not needed at import.
					StringBuilder sb = new StringBuilder("<html><body>");
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
						
						//TRUE MVC ERROR: the query should NOT be on the JSP page...
						String query = DBWorldQueries.getCitiesByDistrictByPopulation();
						//TRUE MVC ERROR: neither should creation of the result set...
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
					
					out.println(sb);
				%>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>