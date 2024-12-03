<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sale Details</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>
<body>

	<div class="container mt-4">
	
		<h1 class="d-flex justify-content-between align-items-end">
			<span><i class="bi-cart-check"></i> Sale Details</span>		
			<a href="${pageContext.request.contextPath}/products" class="btn btn-outline-primary">
				<i class="bi-gift"></i> Products
			</a>
		</h1>
		
		<div class="row">
			<div class="col">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Sale Items</h5>

						<table class="table table-striped">
							<thead>
								<tr>
									<th>Product</th>
									<th class="text-end">Unit Price</th>
									<th class="text-center">Quantity</th>
									<th class="text-end">Total</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="item" items="${sale.items}">
								<tr>
									<td>${item.product.name}</td>
									<td class="text-end"><fmt:formatNumber value="${item.product.price}" /> MMK</td>
									<td class="text-center">${item.quantity}</td>
									<td class="text-end"><fmt:formatNumber value="${item.total}" /> MMK</td>
								</tr>
							</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="2">Total</td>
									<td class="text-center">
										${sale.itemCount}
									</td>
									<td class="text-end">
										<fmt:formatNumber value="${sale.total}" /> MMK
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
			
			<div class="col-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Customer Information</h5>
						
						<div class="mb-3">
							<label class="form-label">Customer Name</label>
							<span class="form-control">
								${sale.customer}
							</span>
						</div>

						<div class="mb-3">
							<label class="form-label">Phone Number</label>
							<span class="form-control">
								${sale.phone}
							</span>
						</div>

						<div class="mb-3">
							<label class="form-label">Email Address</label>
							<span class="form-control">
								${sale.email}
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>