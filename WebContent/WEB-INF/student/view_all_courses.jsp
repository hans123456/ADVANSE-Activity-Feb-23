<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Available Courses</title>
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
	<form>
		<table class="table">
			<tr>
				<td class="col">Enroll?</td>
				<td class="col">Course Code</td>
				<td class="col">Units</td>
				<td class="col">Max # of Students</td>
				<td class="col">Number of Enrollees</td>
			</tr>

			<c:forEach var="course" items="${courses}">
				<tr>
					<td class="col"><input type="checkbox" name="enroll"
						value="${course.getId()}"></td>
					<td class="col">${course.getCourseCode()}</td>
					<td class="col">${course.getUnits()}</td>
					<td class="col">${course.getMaxStudents()}</td>
					<td class="col">${course.getEnrolledStudents()}</td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>