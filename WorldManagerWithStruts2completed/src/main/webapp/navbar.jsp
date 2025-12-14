<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar">
	<ul style="list-style-type:none; padding:0px; margin:0px 0px 0px 0px;">
		<li id="homeLink"><a href="${initParam.baseURL}/Home">Home</a></li>
		<li id="loginLink"><a href="${initParam.baseURL}/Login">Login</a></li>
		<li id="listCitiesLink"><a href="${initParam.baseURL}/Protected/listCities.jsp">View Cities</a></li>
		<li id="listCountriesLink"><a href="${initParam.baseURL}/Protected/listCountries.jsp">View Countries</a></li>
		<c:if test="${sessionScope.authorized_user.authLevel eq 2}">
			<li id="addCityLink"><a href="${initParam.baseURL}/Protected/addCity.jsp">Add a new city</a></li>
		</c:if>
		<li id="signoutLink"><a href="${initParam.baseURL}/SignOut">Sign Out</a></li>
		<li id="clearDataLink"><a href="${initParam.baseURL}/ClearUserData">Clear All User Data</a></li>
		
	</ul>
</div>
