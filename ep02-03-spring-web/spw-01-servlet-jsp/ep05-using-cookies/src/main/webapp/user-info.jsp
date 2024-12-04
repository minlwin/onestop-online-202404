<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container mt-4">
		<h1>User Information</h1>
		
		<c:choose>
			<c:when test="${userInfo ne null}">
				
				<div class="row">
					<div class="col-2">Name</div>
					<div class="col">${userInfo.name}</div>
				</div>
			
				<div class="row">
					<div class="col-2">Phone</div>
					<div class="col">${userInfo.phone}</div>
				</div>

				<div class="row">
					<div class="col-2">Email</div>
					<div class="col">${userInfo.email}</div>
				</div>
			</c:when>
			
			<c:otherwise>
				<div class="alert alert-info">
					There is no user information. Please login again.
				</div>
			
			</c:otherwise>
		
		</c:choose>	
		
		<a href="${pageContext.request.contextPath}/" class="btn btn-primary">Login Page</a>
		
	</div>

</body>
</html>