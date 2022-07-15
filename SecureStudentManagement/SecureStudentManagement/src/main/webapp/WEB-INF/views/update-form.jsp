<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<title>Update Student</title>
</head>

<body>

	<div class="container">
		<h3 style="text-align: center">Students Directory</h3>
		<hr>

		<p class="h4 mb-4">Update Student</p>

		<form action="/SecureStudentManagement/update/${studentId}"
			method="POST">

			<input type="hidden" name="id" value="${studentId}">


			<div class="form-inline" style="text-align: center">
				<input type="text" name="firstName" value="${Student.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">
			</div>
			

			<div class="form-inline" style="text-align: center">
				<input type="text" name="lastName" value="${Student.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">
			</div>
			

			<div class="form-inline" style="text-align: center">
				<input type="text" name="course" value="${Student.course}"
					class="form-control mb-4 col-4" placeholder="Course">
			</div>


			<div class="form-inline" style="text-align: center">
				<input type="text" name="country" value="${Student.country}"
					class="form-control mb-4 col-4" placeholder="Country">
			</div>


			<button type="submit" class="btn btn-info col-2">Update</button>

		</form>

		<hr>
		<a href="/SecureStudentManagement/allStudents">Back to Students List</a>

	</div>

</body>
</html>