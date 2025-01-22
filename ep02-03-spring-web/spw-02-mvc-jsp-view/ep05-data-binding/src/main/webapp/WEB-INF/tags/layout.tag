<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ attribute name="title" required="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data Bind | ${title}</title>

<c:set var="root" value="${pageContext.request.contextPath}" scope="request"></c:set>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>

	<nav class="navbar navbar-expand bg-dark navbar-dark">
		<div class="container">
			<span class="navbar-brand">Data Binding</span>
			
			<ul class="navbar-nav">
				<li class="nav-item">
					<a href="${root}/products" class="nav-link ${title eq 'Products' ? 'active' : ''}">Products</a>
				</li>
				<li class="nav-item">
					<a href="${root}/categories" class="nav-link ${title eq 'Categories' ? 'active' : ''}">Categories</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container mt-4">
		<jsp:doBody></jsp:doBody>
	</div>

</body>
</html>