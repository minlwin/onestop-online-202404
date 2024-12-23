<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" type="java.lang.String" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listener | ${title}</title>

<c:set var="root" scope="request" value="${pageContext.request.contextPath}"></c:set>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="${root}/static/style/application.css" />

</head>
<body>


	<!-- Top Menu -->
	<nav class="navbar navbar-expand shadow-sm">
		<div class="container">
			<a href="${root}/home" class="navbar-brand">
				<i class="bi-house"></i> The Shops
			</a>
			
			<ul class="navbar-nav">
			
				<c:if test="${null ne cart and cart.totalItems gt 0}">
					<li class="nav-item">
						<a href="${root}/checkout" class="nav-link">
							<i class="bi-cart"></i> ${cart.totalItems}
						</a>
					</li>
				</c:if>
			
				<li class="nav-item">
					<a href="${root}/sales" class="nav-link"><i class="bi-cart-check"></i> Sales</a>
				</li>
				<li class="nav-item">
					<a href="${root}/products" class="nav-link"><i class="bi-gift"></i> Products</a>
				</li>
				<li class="nav-item">
					<a href="${root}/categories" class="nav-link"><i class="bi-tags"></i> Categories</a>
				</li>
			</ul>
		</div>
		
		
	</nav>
	
	<!-- Contents -->
	<main class="mt-3 container">
		<jsp:doBody></jsp:doBody>
	</main>

</body>
</html>