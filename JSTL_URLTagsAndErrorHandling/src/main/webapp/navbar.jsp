<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!-- method one: in the anchor -->
<c:url value="index.jsp" var="indexURL" />
<c:url value="login.jsp" var="loginURL" />
<c:url value="errorHandlingInTags.jsp" var="errorHandlingTagsURL" />
<c:url value="errorHandlingInTags2.jsp" var="errorHandlingTagsURL2" />

<c:url value="listCities.jsp" var="cityViewURL" />
<c:url value="listCountries.jsp" var="countryViewURL" />
<c:url value="signout.do" var="signoutController" />
<c:url value="invalidatesessionandremovecookies.do" var = "invalidateSessionRemoveCookiesURL" />
<c:url value="signout.jsp" var="signoutView" />
<a href="${indexURL}">Home</a><br>
<a href="${loginURL}">Login</a><br>
<a href="${errorHandlingTagsURL}">Error Tags</a><br>
<a href="${errorHandlingTagsURL2}">Error Tags 2</a><br>
<a href="${cityViewURL}">View Cities</a><br>
<a href="${countryViewURL}">View Countries</a><br>
<a href="${signoutController}">Sign Out Controller</a><br>
<a href="${invalidateSessionRemoveCookiesURL}">Clear All User Data</a><br>
<a href="${signoutView}">Sign Out View</a><br>
<!-- method two: with parameters -->
<c:url value="urlwithparameters.jsp" var="urlWithParams">
	<c:param name="param_uid" value="infinite_skills" />
	<c:param name="param_pwd" value="1234567890" />
</c:url>
<a href="${urlWithParams}">URL With Params [${urlWithParams}]</a><br>