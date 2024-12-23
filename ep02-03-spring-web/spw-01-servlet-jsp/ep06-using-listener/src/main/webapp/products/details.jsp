<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<app:layout title="Product">
	
	<script src="${root}/static/js/photo-upload.js"></script>
	
	<app:header icon="bi-gift" value="${product.name}"></app:header>
	
	<div class="row">
		<!-- Photos -->
		<div class="col-4">
			
			<div class="mb-4">
			<c:choose>
				
				<c:when test="${null eq product.image}">
					<img class="img-fluid w-100" src="${pageContext.request.contextPath}/static/images/default-image.jpg" alt="Default Image" />	
				</c:when>
				
				<c:otherwise>
					
					<c:forTokens var="photo" items="${product.image}" delims=",">
						<div>
							<img class="img-fluid w-100" src="${pageContext.request.contextPath}/static/images/${photo}" alt="Default Image" />	
						</div>
					</c:forTokens>	
					
				</c:otherwise>
			
			</c:choose>
			</div>
			
			<button id="uploadBtn" class="btn btn-outline-primary">
				<i class="bi-camera"></i> Upload Photos
			</button>
		
		</div>
		
		<!-- Product Info -->
		<div class="col">
			<!-- Name -->
			<div class="mb-3">
				<span class="d-block text-secondary">Name</span>
				<h4 class="d-block">${product.name}</h4>
			</div>
			
			<!-- Category -->
			<div class="mb-3">
				<span class="d-block text-secondary">Category</span>
				<h4 class="d-block">${product.categoryName}</h4>
			</div>
			
			<!-- Price -->
			<div class="mb-3">
				<span class="d-block text-secondary">Price</span>
				<h4 class="d-block">
					<fmt:formatNumber value="${product.price}"></fmt:formatNumber> MMK
				</h4>
			</div>
			
			<!-- Status -->
			<div class="mb-3">
				<span class="d-block text-secondary">Status</span>
				<h4 class="d-block">${product.status}</h4>
			</div>
			
			<!-- Created At -->
			<div class="mb-4">
				<span class="d-block text-secondary">Created At</span>
				<h4 class="d-block">${dateTimes.format(product.createdAt)}</h4>
			</div>
			
			<!-- Sales Informations -->
			<h3><i class="bi-list"></i> Sale Items</h3>
			
			<div class="mt-2">
				<c:choose>
					
					<c:when test="${empty product.saleItems}">
						<div class="alert alert-info">
							There is no sale items.
						</div>
					</c:when>
					
					<c:otherwise>
						
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>Product</th>
									<th>Category</th>
									<th>Sale At</th>
									<th class="text-end">Sale Price</th>
									<th class="text-end">Quantity</th>
									<th class="text-end">Total</th>
								</tr>
							</thead>
							
							<tbody>
							<c:forEach items="${product.saleItems}" var="item">
								<tr>
									<td>${item.product}</td>
									<td>${item.category}</td>
									<td>${dateTimes.format(item.saleAt)}</td>
									<td class="text-end">
										<fmt:formatNumber value="${item.salePrice}"></fmt:formatNumber>
									</td>
									<td class="text-end">
										<fmt:formatNumber value="${item.quantity}"></fmt:formatNumber>
									</td>
									<td class="text-end">
										<fmt:formatNumber value="${item.total}"></fmt:formatNumber>
									</td>
								</tr>
							</c:forEach>	
							</tbody>
						</table>
						
					</c:otherwise>
				
				</c:choose>
			</div>
			
		</div>
	</div>
	
	
	<form id="uploadForm" action="${root}/products/photos" method="post" 
		enctype="multipart/form-data" class="d-none">
		<input name="productId" type="hidden" value="${product.id}" />
		<input name="photos" id="uploadFiles" type="file" multiple="multiple" >
	</form>

</app:layout>