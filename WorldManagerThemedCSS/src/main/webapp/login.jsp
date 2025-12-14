<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
  <title>Welcome to the World Manager</title>
  <link rel="stylesheet" type="text/css" href="css/menubar.css"> 
  <link rel="stylesheet" type="text/css" href="css/sitestyle.css"> 
  <link rel="stylesheet" type="text/css" href="css/ui-darkness/jquery-ui-1.10.3.custom.min.css">
  <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
  <script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js" ></script>
  <script type="text/javascript">
	$(function(){
		$('.addHover').hover(function(){
			$(this).addClass('ui-state-hover');}, 
			function(){
				$(this).removeClass('ui-state-hover');
		});
		
		$('.li[class|="active"]').removeClass("active");
		$('#loginLink').addClass("active");
	});
  </script>
</head>
<body>
	<c:import url="header.jsp" />
	<div class="container">
		<c:import url="navbar.jsp" />
		<div class="content">
			<form id="login" method="post" action="${initParam.baseURL}/loginUser.do">
				<table style="width:450px;">
					<tr>
						<td>
							<span>UserName:</span>
						</td>
						<td>
							<input name="uid" type="text" style="width:250px;" value="${cookie.credentials_uid.value}" />
						</td>
					</tr>
					<tr>
						<td>
							<span>Password:</span>
						</td>
						<td>
							<input name="pwd" type="password" style="width:250px;" value="${cookie.credentials_pwd.value}"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input name="rememberMe" type="checkbox">&nbsp;Remember Me
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">

							<button id="button" class="ui-button ui-widget ui-state-default ui-corner-all 
														ui-button-text-only addHover" 
								role="button" aria-disabled="false" style="width:250px;">
								<span class="ui-button-text">Sign In</span>
							</button>
						</td>
					</tr>
				</table>
				<input type="hidden" name="dest" value="${param.dest}" />
			</form>
		</div>
	</div>			
	<c:import url="footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>

				
			