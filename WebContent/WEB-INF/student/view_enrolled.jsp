<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Enrolled</title>
</head>
<body>

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

	<form>
		<table class="table">
				<tr>
					<td class="col">Drop Course</td>
					<td class="col">Currently Enrolled Courses</td>
					<td class="col">Units</td>
				</tr>
				
				<tr>
					<td class="col"><input type="checkbox" name="drop" value="advanse"></td>
					<td class="col">ADVANSE</td>
					<td class="col">3</td>
				</tr>
		</table>
	</form>
	
	<p>Total units enrolled:  </p>

</body>
</html>