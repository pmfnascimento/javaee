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
	<!-- Use a choose .. when .. otherwise for multiple condition checks -->
	<!-- if the user is not logged in, redirect to login controller -->
	<!-- if the data is not set, redirect to controller to get city data -->
	<c:choose>
		<c:when test="${sessionScope.authorized_user eq null}">
			<c:redirect url="login.jsp?dest=listCountries" />
		</c:when>
		<c:when test="${sessionScope.authorized_user.authLevel ne 1}">
			<c:redirect url="login.jsp?dest=listCountries" />
		</c:when>
		<c:when test="${sessionScope.authorized_user.userId eq null}">
			<c:redirect url="login.jsp?dest=listCountries" />
		</c:when>
		<c:when test="${sessionScope.countryData eq null}">
			<c:redirect url="getcountrydata.do" />
		</c:when>
		<c:otherwise>
			<h1><c:out value="Welcome Back ${sessionScope.authorized_user.userId}" /></h1>
		</c:otherwise>
	</c:choose> 
	
	
	<!-- otherwise, move forward for data display -->
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<c:import url="navbar.jsp" />
			</td>
			<!-- Code Name Continent Region Population HeadOfState -->
			<td style="width:75%;height:80%;">
				<table border=1> 
					<tr>
						<td><b>Code</b></td>
						<td><b>Name</b></td>
						<td><b>Continent</b></td>
						<td><b>Region</b></td>
						<td><b>Population</b></td>
						<td><b>Head_Of_State</b></td>
					</tr>
					
					<c:forEach var="country" items="${sessionScope.countryData}">
						<tr>
							<td>${country.code}</td>
							<td>${country.name}</td>
							<td>${country.continent}</td>
							<td>${country.region}</td>
							<td>${country.population}</td>
							<td>${country.headOfState}</td>
						</tr>
					</c:forEach>
				</table>
				
				<!--  but the head of state is wrong for the US & all US territories -->
				<c:forEach var="tempCountry" items="${sessionScope.countryData}">
					<c:if test="${tempCountry.headOfState eq 'George W. Bush'}" >
						<h3>*****************************************************</h3>
						<h3>Country: ${tempCountry.code} has head of state = ${tempCountry.headOfState}</h3>
						<c:set var="updateCountry" value="${tempCountry}" />
						<h3>Before changes: ${updateCountry}</h3>
						<c:set target="${updateCountry}" property="headOfState" value="Barack H. Obama" />
						<h3>Please update ${tempCountry.code} to have head of state ==> ${updateCountry.headOfState}</h3>
						<h3>New Values: ${updateCountry}</h3>
						<c:remove var="updateCountry" />
						<h3>Variable cleared: ${updateCountry}</h3>
						<h3>*****************************************************</h3>
					</c:if>
				</c:forEach>
			</td>
		</tr>
	</table>
	<c:import url="footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>