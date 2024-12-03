<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sale History</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>
<body>

	<div class="container mt-4">
		
		<h1 class="d-flex justify-content-between align-items-end">
			<span><i class="bi-calendar"></i> Sale History</span>

			<a href="${pageContext.request.contextPath}/products" class="btn btn-outline-primary">
				<i class="bi-gift"></i> Products
			</a>
		</h1>
		
		<table class="table table-striped">
		
			<thead>
				<tr>
					<th>Id</th>
					<th>Customer</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Sale At</th>
					<th>Items</th>
					<th>Total</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="item" items="${saleModel.sales}">
				<tr>
					<td>${item.id}</td>
					<td>${item.customer}</td>
					<td>${item.phone}</td>
					<td>${item.email}</td>
					<td>${item.saleAt}</td>
					<td>${item.itemCount}</td>
					<td>${item.total}</td>
					<td>
						<c:url var="details" value="/sales">
							<c:param name="id" value="${item.id}"></c:param>
						</c:url>
						<a href="${details}" class="icon-link">
							<i class="bi-send"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
	</div>

</body>
</html>