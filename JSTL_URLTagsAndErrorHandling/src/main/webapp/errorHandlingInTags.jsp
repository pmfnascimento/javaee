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
				 <!-- wrap your error prone code in a catch tag -->
				 <c:catch var="myBadCodeBlock">
				 	Result: ${ 32 / 0 }<br>
				 	Result2: <% int x = 32 / 0; %><%= x %>
				 </c:catch>
				 
				 <c:if test="${myBadCodeBlock != null}">
				 	ERROR: ${myBadCodeBlock.message}<br>
				 	ERROR: ${myBadCodeBlock}
				 </c:if>
			</td>
		</tr>
	</table>
	<c:import url="footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>