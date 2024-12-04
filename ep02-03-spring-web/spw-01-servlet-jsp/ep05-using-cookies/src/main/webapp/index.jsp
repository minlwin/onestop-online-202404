<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container mt-4">
		
		<h1>Using Cookies Demo</h1>
		
		<form action="${pageContext.request.contextPath}/login" method="post" class="w-25">
			
			<div class="mb-3">
				<label class="form-label">Name</label>
				<input type="text" name="name" required="required" placeholder="Enter Name" class="form-control" />
			</div>

			<div class="mb-3">
				<label class="form-label">Phone</label>
				<input type="tel" name="phone" required="required" placeholder="Enter Phone" class="form-control" />
			</div>

			<div class="mb-3">
				<label class="form-label">Email</label>
				<input type="email" name="email" required="required" placeholder="Enter Email" class="form-control" />
			</div>
			
			<button type="submit" class="btn btn-primary">
				Login
			</button>
		</form>
	
	</div>

</body>
</html>