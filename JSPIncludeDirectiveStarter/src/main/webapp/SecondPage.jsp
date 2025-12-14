<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<% 
					//application/servlet context from page context
					String dbUIDFail = (pageContext.getAttribute("dbuserid", pageContext.APPLICATION_SCOPE) == null ? "bad" :
						 				(String)pageContext.getAttribute("dbuserid", pageContext.APPLICATION_SCOPE));
					
					String dbUIDSuccess = (application.getInitParameter("dbuserid") == null ? "bad" :
											application.getInitParameter("dbuserid")); 
				
					//session object from page context
					String uid = (pageContext.getAttribute("uid", pageContext.SESSION_SCOPE) == null ? "bad" :
			 						(String)pageContext.getAttribute("uid", pageContext.SESSION_SCOPE));
				
					String sessionCode = (pageContext.getAttribute("SessionCode", pageContext.SESSION_SCOPE) == null ? "bad" :
 											(String)pageContext.getAttribute("SessionCode", pageContext.SESSION_SCOPE));
					
					//try to get secret code from page context
					String scode = (pageContext.getAttribute("SecretCode", pageContext.APPLICATION_SCOPE) == null ? "bad" :
			 						(String)pageContext.getAttribute("SecretCode", pageContext.APPLICATION_SCOPE));
							
					//request param from page context
					String acode = (pageContext.getAttribute("AnotherCode", pageContext.REQUEST_SCOPE) == null ? "bad" :
								 	(String)pageContext.getAttribute("AnotherCode", pageContext.REQUEST_SCOPE));
							
					//query string param from page context
					String pcode = (pageContext.getAttribute("key", pageContext.REQUEST_SCOPE) == null ? "bad" :
					 				(String)pageContext.getAttribute("key", pageContext.REQUEST_SCOPE));
				
					String pcode2 = request.getParameter("key");
							
					//try to get previously set page attribute
					String lcode = (pageContext.getAttribute("LostCode") == null ? "bad" :
		 							(String)pageContext.getAttribute("LostCode"));
							
				%>
				<table style="width:100%;" border="1">
					<tr>
						<td style="width:35%;">pageContext DB User ID</td>
						<%
							if (dbUIDFail.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= dbUIDFail %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= dbUIDFail %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">application DB User ID</td>
						<%
							if (dbUIDSuccess.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= dbUIDSuccess %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= dbUIDSuccess %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">User ID</td>
						<%
							if (uid.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= uid %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= uid %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">Secret Code</td>
						<%
							if (scode.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= scode %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= scode %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">Another Code</td>
						<%
							if (acode.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= acode %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= acode %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">Key</td>
						<%
							if (pcode.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= pcode %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= pcode %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">Key</td>
						<%
							if (pcode2.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= pcode2 %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= pcode2 %></td>
						<%
							}
						%>
					</tr>
					<tr>
						<td style="width:35%;">Lost Code</td>
						<%
							if (lcode.equalsIgnoreCase("BAD"))
							{
						%>
								<td style="width:65%;background-color:#e5b75b;"><%= lcode %></td>
						<%
							}
							else
							{
					    %>
								<td style="width:65%;background-color:#6599ff;"><%= lcode %></td>
						<%
							}
						%>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>