<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Using EL Implicit Objects</title>
</head>
<body>
	Hello ${initParam.dbuserid}<br>
	I see you like to use <br><strong>${header["user-agent"]}</strong><br> to browse!
	<br><br>${pageContext.request.contextPath }
	<br>
	<br><H1>TMI</H1>
	${headerValues}<br><br><br>
	<h2>The application variables tell us:</h2>
	<span>UserID:&nbsp;</span>${applicationScope.uid}
	<br>
	<span>PWD:&nbsp;</span>${applicationScope.pwd}
	<br>
	
	<%
		//set session
		session.setAttribute("uid", "sesUser");
		session.setAttribute("pwd", "12sesUser");
		
		//set cookie
		int cookieLife = 3600*24*7; //7 days
		Cookie uidCook = new Cookie("credentials_uid","cookieUser");
		uidCook.setMaxAge(cookieLife);  //7 days
		response.addCookie(uidCook);
		Cookie pwdCook = new Cookie("credentials_pwd","cookieUserPWD");
		uidCook.setMaxAge(cookieLife);  //7 days
		response.addCookie(pwdCook);
	%>
	
	<br><br>
	<jsp:include page="navbar.jsp" />
</body>
</html>