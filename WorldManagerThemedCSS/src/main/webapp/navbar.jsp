<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="navbar">
<c:choose>
	<c:when test="${pageContext.request.contextPath eq initParam.defaultWebBase}">
		<!-- context is good -->
		<ul style="list-style-type:none; padding:0px; margin:0px 0px 0px 0px;">
			<li id="homeLink"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
			<li id="loginLink"><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
			<li id="listCitiesLink"><a href="${pageContext.request.contextPath}/Protected/listCities.jsp">View Cities</a></li>
			<li id="listCountriesLink"><a href="${pageContext.request.contextPath}/Protected/listCountries.jsp">View Countries</a></li>
			<c:if test="${sessionScope.authorized_user.authLevel eq 2}">
				<li id="addCityLink"><a href="${pageContext.request.contextPath}/Protected/addCity.jsp">Add a new city</a></li>
			</c:if>
			<li id="signoutLink"><a href="${pageContext.request.contextPath}/signout.do">Sign Out</a></li>
			<li id="clearDataLink"><a href="${pageContext.request.contextPath}/invalidatesessionandremovecookies.do">Clear All User Data</a></li>
		</ul>
	</c:when>
	<c:otherwise>
		<!-- use base links -->
		<ul style="list-style-type:none; padding:0px; margin:0px 0px 0px 0px;">
			<li id="homeLink"><a href="${initParam.baseURL}/index.jsp">Home</a></li>
			<li id="loginLink"><a href="${initParam.baseURL}/login.jsp">Login</a></li>
			<li id="listCitiesLink"><a href="${initParam.baseURL}/Protected/listCities.jsp">View Cities</a></li>
			<li id="listCountriesLink"><a href="${initParam.baseURL}/Protected/listCountries.jsp">View Countries</a></li>
			<c:if test="${sessionScope.authorized_user.authLevel eq 2}">
				<li id="addCityLink"><a href="${initParam.baseURL}/Protected/addCity.jsp">Add a new city</a></li>
			</c:if>
			<li id="signoutLink"><a href="${initParam.baseURL}/signout.do">Sign Out</a></li>
			<li id="clearDataLink"><a href="${initParam.baseURL}/invalidatesessionandremovecookies.do">Clear All User Data</a></li>
		</ul>
	</c:otherwise>
</c:choose>
</div>
