<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<shiro:user>
		<%
			response.sendRedirect("/ADVANSE/index.jsp");
		%>
	</shiro:user>

	<h2>Registration</h2>
	<form id="registerform" method="POST" action="/ADVANSE/register">
		Full name:<br> <input type="text" name="fullname"> <br>
		ID Number:<br> <input type="text" name="id_num"> <br>
		Password:<br> <input type="text" name="password"> <br>
		<br /> <input type="submit" value="Submit">
	</form>

	<br /> Login
	<a href="/ADVANSE/login.jsp">here</a>

</body>
</html>