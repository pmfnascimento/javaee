<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
  <c:import url="scriptsandcss.jsp" />
  <script type="text/javascript">
	$(function(){
		$('.addHover').hover(function(){
			$(this).addClass('ui-state-hover');}, 
			function(){
				$(this).removeClass('ui-state-hover');
		});
		
		$('.li[class|="active"]').removeClass("active");
		$('#loginLink').addClass("active");
		
		$('#LoginUser_uid').val($("#cookie_uid_value").val());
		$('#LoginUser_pwd').val($("#cookie_pwd_value").val());
	});
  </script>
  <s:head />
</head>
<body>
	<c:import url="header.jsp" />
	<div class="container">
		<c:import url="navbar.jsp" />
		<div class="content">
			<input type="password" id="cookie_uid_value" value='${cookie["credentials_uid"].value}' style="display:none;" />
			<input type="password" id="cookie_pwd_value" value='${cookie["credentials_pwd"].value}' style="display:none;" />
			
			<s:form action="LoginUser" method="execute">
				<s:textfield name="uid" label="User Name" cssClass="defaultText" />
				<s:password name="pwd" label="Password" cssClass="defaultText"  />
				<s:hidden name="authLevel" value="0" />
				<s:checkbox name="rememberMe" fieldValue="true" label="Remember Me" />
				<s:submit value="Sign In" cssClass="ui-button ui-widget ui-state-default ui-corner-all 
														ui-button-text-only addHover" 
														style="height:40px;width:120px;"/>
			</s:form>
		</div>
	</div>			
	<c:import url="footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>

				
			