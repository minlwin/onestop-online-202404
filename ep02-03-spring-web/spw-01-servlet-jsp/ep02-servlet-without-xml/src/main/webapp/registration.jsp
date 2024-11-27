<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration form</title>

<jsp:include page="bootstrap.jsp"></jsp:include>

</head>
<body>

	<div class="container mt-4">
		
		<h1>Student Registration</h1>
		
		<div class="w-50">
			
			<form action="${pageContext.request.contextPath}/registration" method="post">
			
				<!-- Name -->
				<div class="mb-3">
					<label class="form-label" >Student Name</label>
					<input class="form-control" type="text" name="name" placeholder="Enter Student Name" />
				</div>
				
				<!-- Phone -->
				<div class="mb-3">
					<label class="form-label" >Phone Number</label>
					<input class="form-control" type="tel" name="phone" placeholder="Enter Phone Number" />
				</div>
				
				<!-- Email -->
				<div class="mb-3">
					<label class="form-label" >Email Address</label>
					<input class="form-control" type="email" name="mail" placeholder="Enter Email Address" />
				</div>
				
				<button type="submit" class="btn btn-outline-primary">
					Save Student
				</button>
				
			</form>
			
		</div>
	</div>

</body>
</html>