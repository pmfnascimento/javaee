<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>XML</title>
</head>
<body>
	<c:set var="xCityData">
		<cities>
			<city>
				<id>1</id>
				<name>Chicago</name>
			</city>
			<city>
				<id>2</id>
				<name>London</name>
			</city>
			<city>
				<id>3</id>
				<name>Moscow</name>
			</city>
			<city>
				<id>4</id>
				<name>New York</name>
			</city>
			<city>
				<id>5</id>
				<name>Los Angeles</name>
			</city>
		</cities>
	</c:set>
	<table style="width:100%">
		<tr>
			<td style="width:30%">Tag</td>
			<td style="width:70%">Example</td>
		</tr>
		<tr>
			<td>xml - parse doc</td>
			<td>
				<x:parse var="cityData" xml="${xCityData}" />
				<table style="width:100%;">
					<x:forEach var="city" select="$cityData/cities/city/name">
						<tr>
							<td><x:out select="$city" /></td>
						</tr>
					</x:forEach>
				</table>
			</td>
		</tr>
	</table>
	<c:import url="footer.jsp" />
</body>
</html>