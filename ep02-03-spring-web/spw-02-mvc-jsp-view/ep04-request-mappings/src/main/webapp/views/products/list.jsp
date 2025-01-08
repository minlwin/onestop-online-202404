<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<app:layout>
	
	<div class="d-flex justify-content-between align-items-center w-100">
		<h3>Product Management</h3>
		
		<div>
		
			<c:if test="${cart ne null and cart.totalItems gt 0}">
				<a href="${root}/checkout" class="btn btn-outline-danger">
					<span class="d-inline-block me-2">My Cart</span>
					<i class="bi-cart"></i> ${cart.totalItems}
				</a>
			</c:if>
					
			<a id="uploadBtn" href="#" onclick="return false;" class="btn btn-outline-primary">
				<i class="bi-upload"></i> Upload
			</a>
		</div>
	</div>
	
	<form id="uploadForm" action="${root}/product/upload" enctype="multipart/form-data" method="post" class="d-none" >
		<input id="uploadFile" type="file" name="file" />
	</form>
	
	<!-- Product List -->
	<table class="table table-bordered table-hover mt-3">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Category</th>
				<th class="text-end">Price</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.id()}</td>
				<td>${item.name()}</td>
				<td>${item.category()}</td>
				<td class="text-end"><fmt:formatNumber value="${item.price()}" /> MMK</td>
				<th class="text-center">
					<a href="${root}/cart/add/${item.id()}" class="icon-link">
						<i class="bi-cart-plus"></i>
					</a>
				</th>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<script src="${root}/resources/js/products.js"></script>
</app:layout>