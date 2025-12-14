<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<%@ include file="navbar.jsp" %>
			</td>
			<td style="width:75%;height:80%;">
				<h1>Sessions aren't allowed on this page</h1>
				<%
				 	try
					{
						HttpSession s = request.getSession();
						String uid = (String)s.getAttribute("uid");
						out.println("Hello <strong>" + uid + "</strong>");
					}
					catch (Exception e)
					{
						out.println("Could not access the session");
					}
				%>
				
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>