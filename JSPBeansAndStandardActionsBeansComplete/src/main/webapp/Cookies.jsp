<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cookies!</title>
</head>
<body>
	Hello ${cookie["credentials_uid"].value}
	<br>	
	Access Code: ${cookie.credentials_pwd.value}
	<br>
	<br><br>
	<jsp:include page="navbar.jsp" />
</body>
</html>