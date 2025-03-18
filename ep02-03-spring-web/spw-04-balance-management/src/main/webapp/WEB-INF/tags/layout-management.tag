<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<%@ attribute name="title" required="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BALANCE | ${title.toUpperCase()}</title>

<c:set value="${pageContext.request.contextPath}" var="root" scope="request" />

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="${root}/resources/css/common.css" />

</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand navbar-dark sticky-top bg-dark">
		<div class="container">
			<a href="${root}/admin/home" class="navbar-brand">
				<i class="bi-house"></i> Balance Admin
			</a>
			
			<ul class="navbar-nav">
				<li class="nav-item">
					<a href="${root}/admin/access" class="nav-link ${title eq 'ACCESS' ? 'active' : ''}"><i class="bi-calendar"></i> Access History</a>
				</li>

				<li class="nav-item">
					<a href="${root}/admin/member" class="nav-link ${title eq 'MEMBERS' ? 'active' : ''}"><i class="bi-people"></i> Members</a>
				</li>
				
				<li class="nav-item">
					<a href="#" id="signOutMenu" class="nav-link"><i class="bi-lock"></i> Sign Out</a>
				</li>
			</ul>
		</div>
	</nav>

	<main class="container my-4">
		<jsp:doBody />
	</main>

	<app:sign-out />
</body>
</html>