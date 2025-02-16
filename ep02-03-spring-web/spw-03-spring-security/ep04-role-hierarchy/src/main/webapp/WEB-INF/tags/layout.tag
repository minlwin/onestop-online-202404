<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="menu" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ROLE HIERARCHY</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>

	<div class="navbar navbar-expand shadow">
		<div class="container">
			<span class="navbar-brand">
				ROLE HIERARCHY
			</span>
			
			<ul class="navbar-nav">
				<li class="nav-item">
					<a href="/member" class="nav-link">Member</a>
				</li>
				<li class="nav-item">
					<a href="/staff" class="nav-link">Staff</a>
				</li>
				<li class="nav-item">
					<a href="/manager" class="nav-link">Manager</a>
				</li>
				<li class="nav-item">
					<a href="/admin" class="nav-link">Admin</a>
				</li>
				<li class="nav-item">
					<a href="/logout" class="nav-link">Logout</a>
				</li>
			</ul>
		</div>
	</div>
	
	<div class="container mt-4">
		<jsp:doBody></jsp:doBody>
	</div>

</body>
</html>