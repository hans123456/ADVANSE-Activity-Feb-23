<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<form id ="registerform" method ="POST" action="/ADVANSE/register">
			Full name:<br>
			<input type="text" name="fullname">
			<br>
			ID Number:<br>
			<input type="text" name="idnum">
			<br>
			Password:<br>
			<input type="text" name="password">
			Enrolled Courses:<br>
			<br>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>
