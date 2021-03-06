<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Enrolled</title>
<style>
div.scrollable {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
	overflow: auto;
}

.table {
	table-layout: fixed;
	border-collapse: collapse;
	width: 100%;
}

.col {
	border: 1px solid #000;
	width: 150px;
}
</style>
</head>
<body>
	<c:import url="/student/menu.jsp"></c:import>
	<h2>Your Enrolled Courses</h2>
	<form>
		<table class="table">
			<tr>
				<td class="col">Currently Enrolled Courses</td>
				<td class="col">Units</td>
			</tr>

			<c:set var="total" value="${0}" />
			<c:forEach var="course" items="${courses}">
				<tr>
					<td class="col">${course.getCourseCode()}</td>
					<td class="col">${course.getUnits()}</td>
				</tr>
				<c:set var="total" value="${total + course.getUnits()}" />
			</c:forEach>
		</table>
	</form>

	<p>
		Total units:
		<c:out value="${total}" />
	</p>


</body>
</html>