<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Without Web XML</title>

<jsp:include page="bootstrap.jsp"></jsp:include>

</head>
<body>

	<div class="container mt-4">
		<h1>Servlet Without Web XML</h1>
		
		<ul>
			<li>
				<a href="${pageContext.request.contextPath}/hello">Hello Servlet</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/requestInfo">Request Information</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/registration.jsp">Student Registration</a>
			</li>
		</ul>
	</div>

</body>
</html>