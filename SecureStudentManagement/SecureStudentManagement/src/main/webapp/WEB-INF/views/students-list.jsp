<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Students Directory</title>
</head>
<body>

	<div class="container mt-3">

		<h1>Students Directory</h1>
		<hr>

		<form action="/SecureStudentManagement/save" class="form-inLine"></form>

		<!-- Add a button -->
		<a href="/SecureStudentManagement/add"
			class="btn btn-primary btn-sm mb-3">Add Student</a>
		<div class=row>

			<table class="table table-bordered table-striped">
				<thead class="thead-dark">
					<tr>
						<th style="text-align: center">Student ID</th>
						<th style="text-align: center">First Name</th>
						<th style="text-align: center">Last Name</th>
						<th style="text-align: center">Course</th>
						<th style="text-align: center">Country</th>
						<th style="text-align: center" colspan="2">Action</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${Student}" var="tempStudent">
						<tr>
							<td><c:out value="${tempStudent.studentId}" /></td>
							<td><c:out value="${tempStudent.firstName}" /></td>
							<td><c:out value="${tempStudent.lastName}" /></td>
							<td><c:out value="${tempStudent.course}" /></td>
							<td><c:out value="${tempStudent.country}" /></td>

							<td>
								<!-- Add update button --> <a
								href="/SecureStudentManagement/edit/${tempStudent.studentId}"
								class="btn btn-info btn-sm mx-auto d-block">Update</a>
							</td>

							<td>
								<!-- Add delete button --> <a
								href="/SecureStudentManagement/delete/${tempStudent.studentId}"
								class="btn btn-danger btn-sm mx-auto d-block"
								onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">
									Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>