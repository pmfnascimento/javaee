<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<jsp:include page="navbar.jsp" />
			</td>
			<td style="width:75%;height:80%;">
				<form id="login" method="post" action="loginUser.do">
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
								<input type="submit" value="Sign In" 
								    style="width:250px;" />
							</td>
						</tr>
					</table>
					<input type="hidden" name="dest" value="${param.dest}" />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>