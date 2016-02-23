<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	</head>
	<body>
		<form method ="POST">
			ID Num:<br>
			<input type="text" name="idnum">
			<br>
			Password:<br>
			<input type="text" name="password">
			<br>
			<br>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>