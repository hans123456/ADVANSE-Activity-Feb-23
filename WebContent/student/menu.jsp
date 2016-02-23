<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/ADVANSE/student/view_all_courses">View All Courses</a>
	<br />
	<a href="/ADVANSE/student/view_enrolled">View Enrolled Courses</a>
	<br />
	<a href="">Enroll Course</a>
	<br />
	<a href="">Drop Course</a>
	<br />
	<form id="logout" method="POST" action="/ADVANSE/logout">
		<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>
	</form>
</body>
</html>