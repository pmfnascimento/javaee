<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request Parameters</title>
</head>
<body>
	<jsp:forward page="RequestParameters2.jsp">
		<jsp:param value="rpuid" name="uid"/>
		<jsp:param value="rppwd" name="pwd"/>
	</jsp:forward>
	<jsp:include page="navbar.jsp" />
</body>
</html>