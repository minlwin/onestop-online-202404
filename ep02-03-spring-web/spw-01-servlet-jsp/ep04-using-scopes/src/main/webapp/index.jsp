<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>
<body>
	
	<div class="container mt-4">
		<h1 class="d-flex justify-content-between align-items-end">
			Products
			
			<c:if test="${null ne cart}">
				<a href="" class="btn btn-outline-primary">
					Check Out <i class="bi-cart"></i> ${cart.itemCount}
				</a>
			</c:if>
		</h1>
		
		<table class="table table-striped">
			
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Category</th>
					<th>Price</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="item" items="${productModel.products}">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.category}</td>
					<td>${item.price}</td>
					<th>
						
						<c:url var="addToCart" value="/products/add">
							<c:param name="productId" value="${item.id}" />
						</c:url>
						
						<a href="${addToCart}" class="icon-link">
							<i class="bi-cart-plus"></i>
						</a>
					</th>
				</tr>
			</c:forEach>
			</tbody>
		
		</table>
	</div>
</body>
</html>