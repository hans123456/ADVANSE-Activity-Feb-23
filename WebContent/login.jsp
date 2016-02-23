<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<shiro:user>
		<%
			response.sendRedirect("/ADVANSE/index.jsp");
		%>
	</shiro:user>
	<c:if test="${shiroLoginFailure != null}">Incorrect Username or Password.<br />
	</c:if>
	<form method="POST" action="">
		ID Num:<br> <input type="text" name="id_num" id="id_num">
		<br> Password:<br> <input type="text" name="password"
			id="password"> <br> <br> <input type="submit"
			value="Login">
	</form>
	<br /> Register
	<a href="/ADVANSE/register.jsp">here</a>
</body>
</html>