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
				<!--  <h1>Welcome to the World manager web system</h1>-->
				<h1><c:out value="Welcome to the World Manager Web System" /></h1>
				
				<!--  Now use c-if and EL instead of scriptlets-->
				<c:if test="${sessionScope.authorized_user ne null}">
					<h2><c:out value="${sessionScope.authorized_user.userId}" /></h2>
				</c:if>
				<c:if test="${sessionScope.authorized_user eq null}">
					<h2><c:out value="Returning users login" /></h2>
							<a href="login.jsp">here</a>
				</c:if>
				
				<!-- 
				<c:if test="${sessionScope.authorized_user != null}">
					<h2><c:out value="${sessionScope.authorized_user.userId}" /></h2>
				</c:if>
				<c:if test="${sessionScope.authorized_user == null}">
					<h2><c:out value="Returning users login" /></h2>
							<a href="login.jsp">here</a>
				</c:if>
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