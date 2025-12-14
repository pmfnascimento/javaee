<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="wmelf" uri="WorldManagerELFunctions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demonstrate Custom EL Functions</title>
</head>
<body>
	<h2>SQUARE of 2.0:</h2>
	<span>${wmelf:square(2.0)}</span>
	<h2>CUBE of 2.0:</h2>
	<span>${wmelf:cube(2.0)}</span>
	<h2>SQUARE ROOT of 16.0</h2>
	<span>${wmelf:sqrt(16.0)}</span>
</body>
</html>