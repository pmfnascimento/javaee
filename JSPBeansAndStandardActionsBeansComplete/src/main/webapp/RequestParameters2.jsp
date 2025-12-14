<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RP2</title>
</head>
<body>
	<h1>All Parameters</h1>
	${paramValues}
	
	<h1>UID</h1>
	${param.uid}
	<h1>PWD</h1>
	${param.pwd}
	<br><br>
	<jsp:include page="navbar.jsp" />
</body>
</html>