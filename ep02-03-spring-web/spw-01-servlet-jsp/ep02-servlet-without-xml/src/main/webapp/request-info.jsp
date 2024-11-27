<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Information</title>

<jsp:include page="bootstrap.jsp"></jsp:include>

</head>
<body>

	<div class="container mt-4">
		
		<h1>Request Information</h1>
		
		
		<table class="table table-striped w-50">
			<tr>
				<td>Context Path</td>
				<td>${contextPath}</td>
			</tr>
			<tr>
				<td>Servlet Path</td>
				<td>${servletPath}</td>
			</tr>
			<tr>
				<td>Server Port</td>
				<td>${serverPort}</td>
			</tr>
		</table>

		<div class="mt-3">
			<a href="${pageContext.request.contextPath}" class="btn btn-primary">Home</a>
		</div>		
	</div>

</body>
</html>