<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Result</title>

<jsp:include page="bootstrap.jsp"></jsp:include>

</head>
<body>

	<div class="container mt-4">
		
		<h1>Registration Result</h1>
		
		<div class="w-50">
		
			<table class="table table-striped">
				
				<tr>
					<td>Student ID</td>
					<td>${student.id()}</td>
				</tr>
			
				<tr>
					<td>Student Name</td>
					<td>${student.name()}</td>
				</tr>

				<tr>
					<td>Phone Number</td>
					<td>${student.phone()}</td>
				</tr>

				<tr>
					<td>Email Address</td>
					<td>${student.email()}</td>
				</tr>

			</table>
		
		</div>
	
	</div>

</body>
</html>