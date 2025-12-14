<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
</head>
<body>
	<c:import url="header.jsp" />
	
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<c:import url="navbar.jsp" />
			</td>
			<td style="width:75%;height:80%;">
				<!-- session scope -->
				<c:if test="${sessionScope.authorized_user != null}">
					<h3>BEFORE: Authorized User = ${sessionScope.authorized_user.userId}</h3>
				</c:if>
				<c:remove var="authorized_user" scope="session" />
				<h3>AFTER: Authorized User = ${sessionScope.authorized_user.userId}</h3>
				<!-- set/remove work for other scopes as well, request, application, like pageContext 
					 so technically we can adjust scope variables but for the most part session variables
					 should be handled from the controllers to stay more true to MVC, as object management
					 is part of the controller's responsibility and the view should simply render and interact
					 with the data.
				-->
			</td>
		</tr>
	</table>
	<c:import url="footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>