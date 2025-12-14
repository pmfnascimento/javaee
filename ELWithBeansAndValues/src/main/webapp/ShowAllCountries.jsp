<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, com.worldmanager.models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<jsp:include page="navbar.jsp" />
			</td>
			<td style="width:75%;height:80%;">
				<table style="width:100%" border="1" >
					<%
						//we still don't have a way to loop...yet
						//so instead, we'll use java code to loop
						ArrayList<Country> allCountries = (ArrayList<Country>)session.getAttribute("AllCountries");
						StringBuilder sb = new StringBuilder("");
						sb.append("<tr><td>Name</td><td>Code</td><td>"
							+ "Region</td><td>Continent</td>");
						for (Country c : allCountries)
						{
							sb.append("<tr>");
							
							sb.append("<td>" + c.getName() + "</td>");
							sb.append("<td>" + c.getCode() + "</td>");
							sb.append("<td>" + c.getRegion() + "</td>");
							sb.append("<td>" + c.getContinent() + "</td>");
							
							sb.append("</tr>");
						}
						out.println(sb);
					%>
				</table>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>