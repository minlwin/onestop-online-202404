<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sc" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security | ${title ne null ? title : 'Home'} </title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>
<body>

	<!-- Nav Bar -->
	<nav class="navbar navbar-expand shadow">
		<div class="container d-flex justify-content-between">
			<a href="${pageContext.request.contextPath}" class="navbar-brand">
				<i class="bi-house"></i> Security Home
			</a>
			
			<ul class="navbar-nav">
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/admin" class="nav-link">
						Admin Home
					</a>
				</li>
				
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/member" class="nav-link">
						Member Home
					</a>
				</li>

				<sc:authorize access="isAnonymous">
					<a href="${pageContext.request.contextPath}/authenticate" class="nav-link">
						Login
					</a>
				</sc:authorize>
				
				<sc:authorize access="authenticated">
					<li class="nav-item">
						<a href="#" id="logoutMenu" class="nav-link">
							Logout
						</a>
					</li>
				</sc:authorize>
			</ul>
		</div>
	</nav>
	
	<!-- Content -->
	<main class="mt-4 container">
		<jsp:doBody></jsp:doBody>
	</main>
	
	
	<sc:authorize access="authenticated">
		<form id="logoutForm" cssClass="d-none" action="${pageContext.request.contextPath}/logout" method="post">
			<sc:csrfInput/>
		</form>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/application.js"></script>
	</sc:authorize>
</body>
</html>