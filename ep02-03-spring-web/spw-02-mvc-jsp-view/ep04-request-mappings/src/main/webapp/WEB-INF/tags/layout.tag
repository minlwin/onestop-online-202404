<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Handler</title>

<c:set value="${pageContext.request.contextPath}" var="root" scope="request"></c:set>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<span class="navbar-brand">Request Handler</span>
			
			<ul class="navbar-nav">
				<li class="nav-item">
					<a href="${root}/product" class="nav-link">Products</a>
				</li>
				<li class="nav-item">
					<a href="${root}/validation" class="nav-link">Form Validation</a>
				</li>
				<li class="nav-item">
					<a href="${root}/inputs" class="nav-link">Input Values</a>
				</li>
				<li class="nav-item">
					<a href="${root}/returns" class="nav-link">Return Types</a>
				</li>
			</ul>
		</div>
	</nav>
	
	<!-- Content -->
	<main class="container mt-3">
		<jsp:doBody></jsp:doBody>
	</main>

</body>
</html>