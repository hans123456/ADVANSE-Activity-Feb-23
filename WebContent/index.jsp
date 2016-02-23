<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	${shiroLoginFailure}
	<shiro:guest>
		<c:if test="${shiroLoginFailure != null}">Incorrect Username or Password.<br /></c:if>
		<form method="POST" action="">
			ID Num:<br> <input type="text" name="id_num" id="id_num"> <br>
			Password:<br> <input type="text" name="password" id="password"> <br>
			<br> <input type="submit" value="Login">
		</form>
		<br />
			Register <a href="/ADVANSE/register.jsp">here</a>
	</shiro:guest>

	<shiro:user>
		Success
	</shiro:user>

</body>
</html>