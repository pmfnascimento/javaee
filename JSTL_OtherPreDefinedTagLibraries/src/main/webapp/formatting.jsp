<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formatting</title>
</head>
<body>

	<c:set var="testDate" value="<%=new java.util.Date(44,6,6,13,8,27)%>" />
	<c:set var="testNumber" value="2.99" />
	<table style="width:100%">
		<tr>
			<td style="width:30%">Tag</td>
			<td style="width:70%">Example</td>
		</tr>
		<tr>
			<td>formatNumber - currency</td>
			<td><fmt:formatNumber type="currency" value="${testNumber}" /></td>
		</tr>
		<tr>
			<td>formatNumber - pattern</td>
			<td><fmt:formatNumber type="number" pattern="####.###E0" value="${testNumber}" /></td>
		</tr>
		<tr>
			<td>formatNumber - percent</td>
			<td><fmt:formatNumber type="percent" value="${testNumber}" /></td>
		</tr>
		<tr>
			<td>formatDate - pattern</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${testDate}" /></td>
		</tr>
		<tr>
			<td>formatDate - long/short mix</td>
			<td><fmt:formatDate type="both" dateStyle="long" timeStyle="short" value="${testDate}" /></td>
		</tr>
		<tr>
			<td>formatDate - medium/long mix</td>
			<td><fmt:formatDate type="both" dateStyle="medium" timeStyle="long" value="${testDate}" /></td>
		</tr>
		<tr>
			<td>formatDate - time only</td>
			<td><fmt:formatDate type="time" timeStyle="medium" value="${testDate}" /></td>
		</tr>
		<tr>
			<td>formatDate - date only</td>
			<td><fmt:formatDate type="date" dateStyle="short" value="${testDate}" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<h4>There are others not shown here but can easily be researched if needed</h4>
				<h5>i.e. fmt:timeZone; fmt:setLocale; fmt:requestEncoding, etc</h5>
			</td>
		</tr>
	</table>
	<c:import url="footer.jsp" />
</body>
</html>