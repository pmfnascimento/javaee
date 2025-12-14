<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<%! 
					String uid = "";
					String pwd = "";
				%>
				<% 
					uid = (request.getParameter("uid") != null 
							? request.getParameter("uid")
							: "");
					pwd = (request.getParameter("secretCode") != null
							? request.getParameter("secretCode")
							: "");
				%>
				<span>UserName:</span>&nbsp;
				<input type="text" value="<%=uid%>" /><br>
				<span>Password:</span>&nbsp;
				<input type="password" value="<%=pwd%>" /><br>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>