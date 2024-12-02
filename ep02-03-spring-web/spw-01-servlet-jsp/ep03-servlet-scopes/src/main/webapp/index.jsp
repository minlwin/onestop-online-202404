<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope Demo</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	
	<c:set var="count" scope="page" value="5"></c:set>
	
	<div class="container mt-4">
		
		<h1>Scope Demo</h1>
		
		<table class="w-25 table table-bordered">
			<tr>
				<td>Request Scope</td>
				<td>${requestScope.counter.count}</td>
			</tr>
			
			<tr>
				<td>Session Scope</td>
				<td>${sessionScope.counter.count}</td>
			</tr>

			<tr>
				<td>Application Scope</td>
				<td>${applicationScope.counter.count}</td>
			</tr>

			<tr>
				<td colspan="2">
					<a href="${pageContext.request.contextPath}/scope" class="btn btn-primary">
						Count Up
					</a>
				</td>
			</tr>
		</table>
		
	</div>
</body>
</html>