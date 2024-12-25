<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>

	<h1>Spring MVC with JSP View</h1>
	
	<p>${message}</p>
	
	<ul>
	
	<c:forEach var="item" items="${products}">
		<li>${item.name}</li>
	</c:forEach>
	
	</ul>

</body>
</html>