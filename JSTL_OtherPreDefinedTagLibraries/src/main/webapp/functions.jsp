<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Functions</title>
</head>
<body>
	<c:set var="testString" value="JSTL is very powerful" />
	<table style="width:100%">
		<tr>
			<td style="width:30%">function</td>
			<td style="width:70%">Example</td>
		</tr>
		<tr>
			<td>contains</td>
			<td>
				<c:if test="${fn:contains(testString, 'powerful')}">
					<h3>"${testString}" contains 'powerful' is true</h3>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>containsIgnoreCase</td>
			<td>
				<c:if test="${fn:containsIgnoreCase(testString, 'jstl')}">
					<h3>"${testString}" containsIgnoreCase 'jstl' is true</h3>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>indexOf</td>
			<td>
				<h3>indexOf 'T' = ${fn:indexOf(testString, 'T')}</h3>
			</td>
		</tr>
		<tr>
			<td>length</td>
			<td>
				<h3>length of "${testString}" = ${fn:length(testString)}</h3>
			</td>
		</tr>
		<tr>
			<td>substring</td>
			<td>
				<h3>substring of "${testString}" from 8 to 23 = ${fn:substring(testString, 8, 23)}</h3>
			</td>
		</tr>
		<tr>
			<td>toLowerCase</td>
			<td>
				<h3>lowercase: ${fn:toLowerCase(testString)}</h3>
			</td>
		</tr>
		<tr>
			<td>toUpperCase</td>
			<td>
				<h3>UPPERCASE: ${fn:toUpperCase(testString)}</h3>
			</td>
		</tr>
	</table>
	<c:import url="footer.jsp" />
</body>
</html>